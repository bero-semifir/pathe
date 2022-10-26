package com.semifir.pathe.controllers;

import com.semifir.pathe.models.Salle;
import com.semifir.pathe.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("salles")
public class SalleController extends GenericCrudController<Salle>{

    private SalleRepository repository;

    @Autowired
    public SalleController(SalleRepository repository) {
        super(repository);
    }
}
