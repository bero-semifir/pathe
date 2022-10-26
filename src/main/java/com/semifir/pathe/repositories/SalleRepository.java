package com.semifir.pathe.repositories;

import com.semifir.pathe.models.Salle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends MongoRepository<Salle, String> {
    // permet de trouver toutes les salles d'un cinema
    List<Salle> findByCinema(String cinemaId);
}
