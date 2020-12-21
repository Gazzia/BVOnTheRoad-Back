package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Film;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface FilmService {
    List<Film> listFilms();
    Optional<Film> getFilm(Long id);
    Film insertFilm(Film film);
    Film updateFilm(Long id, Film film);
    void deleteFilm(Long id);
}
