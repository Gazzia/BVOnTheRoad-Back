package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Actor;
import com.breizhvideo.ontheroad.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorServiceImpl implements ActorService{

    @Autowired
    private ActorRepository repository;

    @Override
    public List<Actor> listActors() {
        return repository.findAll();
    }

    @Override
    public Optional<Actor> getActor(Long id) {
        return repository.findById(id);
    }

    @Override
    public Actor insertActor(Actor actor) {
        return repository.save(actor);
    }

    @Override
    public Actor updateActor(Long id, Actor actor) {
        Optional<Actor> optionalActor = this.getActor(id);
        if(optionalActor.isPresent()) {
            return repository.save(actor);
        }
        return null;
    }

    @Override
    public void deleteActor(Long id) {
        Optional<Actor> actor = this.getActor(id);
        actor.ifPresent(value -> repository.delete(value));
    }
}