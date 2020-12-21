package com.breizhvideo.ontheroad.controller;

import com.breizhvideo.ontheroad.model.Film;
import com.breizhvideo.ontheroad.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public List<Film> getFilms(){
        return filmService.listFilms();
    }

    @GetMapping("/films/{id}")
    ResponseEntity<Film> getFilmById(@PathVariable(value="id") long id) {
        Optional<Film> film = filmService.getFilm(id);
        if (film.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(film.get());
    }

    @PostMapping("/films")
    public Film postFilm(@RequestBody Film film){
        return filmService.insertFilm(film);
    }

    @DeleteMapping("/films/{id}")
    public void deleteFilm(@PathVariable(value="id") long id){
        filmService.deleteFilm(id);
    }
}
