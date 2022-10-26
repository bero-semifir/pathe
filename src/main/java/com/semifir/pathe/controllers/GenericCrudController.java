package com.semifir.pathe.controllers;

import com.semifir.pathe.exceptions.NotFoundException;
import com.semifir.pathe.models.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericCrudController<Entite> {

    MongoRepository<Entite, String> repository;

    public GenericCrudController(MongoRepository<Entite, String> repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Entite> findAll(){
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Entite> findById(@PathVariable String id){
        return this.repository.findById(id);
    }


    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void create(@RequestBody Entite entite){
        this.repository.save(entite);
    }

    @PutMapping
    public void update(@RequestBody Entite entite){
        this.repository.save(entite);
    }

    @PutMapping("{id}")
    public Entite update(@PathVariable String id, @RequestBody Entite entite){
        Optional<Entite> entiteOpt = this.repository.findById(id);
        if (entiteOpt.isEmpty()){
            throw new NotFoundException();
        }
        this.repository.save(entite);
        return entite;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        this.repository.deleteById(id);
    }

}
