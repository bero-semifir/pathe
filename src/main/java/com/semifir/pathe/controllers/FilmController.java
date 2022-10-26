package com.semifir.pathe.controllers;

import com.semifir.pathe.exceptions.NotFoundException;
import com.semifir.pathe.models.Film;
import com.semifir.pathe.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("films")
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping
    public List<Film> findAll(){
        return this.filmService.findAll();
    }

    // GET /films/51qsdf3q1sdf3q21
    @GetMapping("{id}")
    public Optional<Film> findById(@PathVariable String id){
        return this.filmService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED, reason = "Film créé")
    public void create(@RequestBody Film film){
        this.filmService.save(film);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        this.filmService.delete(id);
    }

    @PutMapping
    public Film update(@RequestBody Film film){
        Optional<Film> filmOpt = this.filmService.findById(film.getId());
        if (filmOpt.isEmpty()){
            throw new NotFoundException();
        }
        this.filmService.save(film);
        return film;
    }

    @PutMapping("{id}")
    public Film updateById(@PathVariable String id, @RequestBody Film film){
        // récup l'ancien film à partir de l'id en path
        Optional<Film> filmOpt = this.filmService.findById(id);
        // vérif de son existence
        if (filmOpt.isEmpty()){
            throw new NotFoundException();
        }
        this.filmService.save(film);
        return film;
    }

}
