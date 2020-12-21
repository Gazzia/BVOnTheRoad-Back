package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Village;
import com.breizhvideo.ontheroad.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VillageServiceImpl implements VillageService{

    @Autowired
    private VillageRepository repository;

    @Override
    public List<Village> listVillages(String search) {
        if(!"".equals(search))
            return repository.findByNameContaining(search);
        else
            return repository.findAll();
    }

    @Override
    public Optional<Village> getVillage(Long id) {
        return repository.findById(id);
    }

    @Override
    public Village insertVillage(Village village) {
        return repository.save(village);
    }

    @Override
    public Village updateVillage(Long id, Village village) {
        Optional<Village> optionalVillage = this.getVillage(id);
        if(optionalVillage.isPresent()) {
            return repository.save(village);
        }
        return null;
    }

    @Override
    public void deleteVillage(Long id) {
        Optional<Village> village = this.getVillage(id);
        village.ifPresent(value -> repository.delete(value));
    }
}
