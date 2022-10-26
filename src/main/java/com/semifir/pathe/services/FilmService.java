package com.semifir.pathe.services;

import com.semifir.pathe.models.Film;
import com.semifir.pathe.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public List<Film> findAll(){
        return this.filmRepository.findAll();
    }

    public Optional<Film> findById(String id) {
        return this.filmRepository.findById(id);
    }

    public void save(Film film) {
        this.filmRepository.save(film);
    }

    public void delete(String id) {
        this.filmRepository.deleteById(id);
    }
}
