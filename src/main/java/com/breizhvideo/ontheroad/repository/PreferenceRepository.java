package com.breizhvideo.ontheroad.repository;

import com.breizhvideo.ontheroad.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}