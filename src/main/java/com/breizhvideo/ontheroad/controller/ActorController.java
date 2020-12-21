package com.breizhvideo.ontheroad.controller;

import com.breizhvideo.ontheroad.model.Actor;
import com.breizhvideo.ontheroad.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ActorController {
    @Autowired
    ActorService actorService;

    @GetMapping("/actors")
    public List<Actor> getActors(){
        return actorService.listActors();
    }

    @GetMapping("/actors/{id}")
    ResponseEntity<Actor> getActorById(@PathVariable(value="id") long id) {
        Optional<Actor> actor = actorService.getActor(id);
        if (actor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(actor.get());
    }

    @PostMapping("/actors")
    public Actor postActor(@RequestBody Actor actor){
        return actorService.insertActor(actor);
    }

    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable(value="id") long id){
        actorService.deleteActor(id);
    }

}
