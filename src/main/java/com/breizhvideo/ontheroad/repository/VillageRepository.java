package com.breizhvideo.ontheroad.repository;

import com.breizhvideo.ontheroad.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
    List<Village> findByNameContaining(String name);
}