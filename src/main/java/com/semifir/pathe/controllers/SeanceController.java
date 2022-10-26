package com.semifir.pathe.controllers;

import com.semifir.pathe.models.Salle;
import com.semifir.pathe.models.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seances")
public class SeanceController extends GenericCrudController<Seance> {

    @Autowired
    public SeanceController(MongoRepository<Seance, String> repository) {
        super(repository);
    }
}
