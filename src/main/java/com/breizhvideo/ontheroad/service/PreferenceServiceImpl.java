package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Preference;
import com.breizhvideo.ontheroad.repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PreferenceServiceImpl implements PreferenceService{

    @Autowired
    private PreferenceRepository repository;

    @Override
    public List<Preference> listPreferences() {
        return repository.findAll();
    }

    @Override
    public Optional<Preference> getPreference(Long id) {
        return repository.findById(id);
    }

    @Override
    public Preference insertPreference(Preference preference) {
        return repository.save(preference);
    }

    @Override
    public Preference updatePreference(Long id, Preference preference) {
        Optional<Preference> optionalPreference = this.getPreference(id);
        if(optionalPreference.isPresent()) {
            return repository.save(preference);
        }
        return null;
    }

    @Override
    public void deletePreference(Long id) {
        Optional<Preference> preference = this.getPreference(id);
        preference.ifPresent(value -> repository.delete(value));
    }
}
