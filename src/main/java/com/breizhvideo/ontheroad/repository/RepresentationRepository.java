package com.breizhvideo.ontheroad.repository;

import com.breizhvideo.ontheroad.model.Representation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentationRepository extends JpaRepository<Representation, Long> {
}