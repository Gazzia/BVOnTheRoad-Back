package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Preference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface PreferenceService {
    List<Preference> listPreferences();
    Optional<Preference> getPreference(Long id);
    Preference insertPreference(Preference preference);
    Preference updatePreference(Long id, Preference preference);
    void deletePreference(Long id);
}
