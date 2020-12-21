package com.breizhvideo.ontheroad.controller;

import com.breizhvideo.ontheroad.model.Village;
import com.breizhvideo.ontheroad.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class VillageController {
    @Autowired
    VillageService villageService;

    @GetMapping("/villages")
    public List<Village> getVillages(){
        return villageService.listVillages("");
    }

    public ResponseEntity<List<Village>> getVillages(@RequestParam(value = "search", defaultValue = "") String search){
        List<Village> listVillage;
        try{
            listVillage = villageService.listVillages(search);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listVillage);
    }

    @GetMapping("/villages/{id}")
    ResponseEntity<Village> getVillageById(@PathVariable(value="id") long id) {
        Optional<Village> village = villageService.getVillage(id);
        if (village.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(village.get());
    }

    @PostMapping("/villages")
    public Village postVillage(@RequestBody Village village){
        return villageService.insertVillage(village);
    }

    @DeleteMapping("/villages/{id}")
    public void deleteVillage(@PathVariable(value="id") long id){
        villageService.deleteVillage(id);
    }

}

