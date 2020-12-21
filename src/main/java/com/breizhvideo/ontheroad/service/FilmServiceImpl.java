package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Film;
import com.breizhvideo.ontheroad.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository repository;

    @Override
    public List<Film> listFilms() {
        return repository.findAll();
    }

    @Override
    public Optional<Film> getFilm(Long id) {
        return repository.findById(id);
    }

    @Override
    public Film insertFilm(Film film) {
        return repository.save(film);
    }

    @Override
    public Film updateFilm(Long id, Film film) {
        Optional<Film> optionalFilm = this.getFilm(id);
        if(optionalFilm.isPresent()) {
            return repository.save(film);
        }
        return null;
    }

    @Override
    public void deleteFilm(Long id) {
        Optional<Film> film = this.getFilm(id);
        film.ifPresent(value -> repository.delete(value));
    }
}
