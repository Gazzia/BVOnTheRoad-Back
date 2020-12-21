package com.breizhvideo.ontheroad.controller;

import com.breizhvideo.ontheroad.model.Preference;
import com.breizhvideo.ontheroad.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class PreferenceController {
    @Autowired
    PreferenceService preferenceService;

    @GetMapping("/preferences")
    public List<Preference> getPreferences(){
        return preferenceService.listPreferences();
    }

    @GetMapping("/preferences/{id}")
    ResponseEntity<Preference> getPreferenceById(@PathVariable(value="id") long id) {
        Optional<Preference> preference = preferenceService.getPreference(id);
        if (preference.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(preference.get());
    }

    @PostMapping("/preferences")
    public Preference postPreference(@RequestBody Preference preference){
        return preferenceService.insertPreference(preference);
    }

    @DeleteMapping("/preferences/{id}")
    public void deletePreference(@PathVariable(value="id") long id){
        preferenceService.deletePreference(id);
    }

}
