package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Representation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface RepresentationService {
    List<Representation> listRepresentations();
    Optional<Representation> getRepresentation(Long id);
    Representation insertRepresentation(Representation representation);
    Representation updateRepresentation(Long id, Representation representation);
    void deleteRepresentation(Long id);
}
