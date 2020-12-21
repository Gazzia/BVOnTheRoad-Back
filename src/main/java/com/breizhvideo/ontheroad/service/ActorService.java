package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Actor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface ActorService {
    List<Actor> listActors();
    Optional<Actor> getActor(Long id);
    Actor insertActor(Actor actor);
    Actor updateActor(Long id, Actor actor);
    void deleteActor(Long id);
}
