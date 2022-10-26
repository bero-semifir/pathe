package com.semifir.pathe.controllers;

import com.semifir.pathe.models.Cinema;
import com.semifir.pathe.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/generic/cinemas")
public class CinemaCrudController extends GenericCrudController<Cinema>{

    @Autowired
    public CinemaCrudController(CinemaRepository repository) {
        super(repository);
    }

    // pour faire une recherche
    // /generic/cinemas/search?nom=Pathé
    @GetMapping("search")
    public Optional<Cinema> findByNom(@RequestParam String nom){
        CinemaRepository repo = (CinemaRepository) this.repository;
        return repo.findByNom(nom);
    }
}
