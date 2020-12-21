package com.breizhvideo.ontheroad.service;


import com.breizhvideo.ontheroad.model.Village;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface VillageService {
    List<Village> listVillages(String search);
    Optional<Village> getVillage(Long id);
    Village insertVillage(Village Village);
    Village updateVillage(Long id, Village Village);
    void deleteVillage(Long id);
}
