package com.semifir.pathe.controllers;

import com.semifir.pathe.exceptions.NotFoundException;
import com.semifir.pathe.models.Cinema;
import com.semifir.pathe.models.Salle;
import com.semifir.pathe.repositories.CinemaRepository;
import com.semifir.pathe.repositories.SalleRepository;
import com.semifir.pathe.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cinemas")
public class CinemaController {

    private final CinemaRepository repository;
    private final SalleRepository salleRepository;

    @Autowired
    public CinemaController(CinemaRepository repository, SalleRepository salleRepository) {
        this.repository = repository;
        this.salleRepository = salleRepository;
    }

    @GetMapping
    public List<Cinema> findAll(){
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Cinema> findById(@PathVariable String id){
        return this.repository.findById(id);
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void create(@RequestBody Cinema cinema){
        this.repository.save(cinema);
    }

    @PutMapping
    public void update(@RequestBody Cinema cinema){
        this.repository.save(cinema);
    }

    @PutMapping("{id}")
    public Cinema update(@PathVariable String id, @RequestBody Cinema cinema){
        Optional<Cinema> cinemaOpt = this.repository.findById(id);
        if (cinemaOpt.isEmpty()){
            throw new NotFoundException();
        }
        this.repository.save(cinema);
        return cinema;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        this.repository.deleteById(id);
    }

    @GetMapping("{cinemaId}/salles")
    public List<Salle> findAllSalles(@PathVariable String cinemaId)
    {
        Optional<Cinema> cinemaOpt = this.repository.findById(cinemaId);
        if(cinemaOpt.isEmpty()){
            throw new NotFoundException();
        }
        return cinemaOpt.get().getSalles();
    }

}
