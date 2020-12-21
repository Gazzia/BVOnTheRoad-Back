package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Representation;
import com.breizhvideo.ontheroad.repository.RepresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepresentationServiceImpl implements RepresentationService{

    @Autowired
    private RepresentationRepository repository;

    @Override
    public List<Representation> listRepresentations() {
        return repository.findAll();
    }

    @Override
    public Optional<Representation> getRepresentation(Long id) {
        return repository.findById(id);
    }

    @Override
    public Representation insertRepresentation(Representation representation) {
        return repository.save(representation);
    }

    @Override
    public Representation updateRepresentation(Long id, Representation representation) {
        Optional<Representation> optionalRepresentation = this.getRepresentation(id);
        if(optionalRepresentation.isPresent()) {
            return repository.save(representation);
        }
        return null;
    }

    @Override
    public void deleteRepresentation(Long id) {
        Optional<Representation> representation = this.getRepresentation(id);
        representation.ifPresent(value -> repository.delete(value));
    }
}
