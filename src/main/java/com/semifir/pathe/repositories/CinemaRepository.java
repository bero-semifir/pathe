package com.semifir.pathe.repositories;

import com.semifir.pathe.models.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepository extends MongoRepository<Cinema, String> {
    Optional<Cinema> findByNom(String nom);
}
