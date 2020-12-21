package com.breizhvideo.ontheroad.controller;

import com.breizhvideo.ontheroad.model.Representation;
import com.breizhvideo.ontheroad.service.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class RepresentationController {
    @Autowired
    RepresentationService representationService;

    @GetMapping("/representations")
    public List<Representation> getRepresentations(){
        return representationService.listRepresentations();
    }

    @GetMapping("/representations/{id}")
    ResponseEntity<Representation> getRepresentationById(@PathVariable(value="id") long id) {
        Optional<Representation> representation = representationService.getRepresentation(id);
        if (representation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(representation.get());
    }

    @PostMapping("/representations")
    public Representation postRepresentation(@RequestBody Representation representation){
        return representationService.insertRepresentation(representation);
    }

    @DeleteMapping("/representations/{id}")
    public void deleteRepresentation(@PathVariable(value="id") long id){
        representationService.deleteRepresentation(id);
    }

}

