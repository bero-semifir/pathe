package com.semifir.pathe.repositories;

import com.semifir.pathe.models.Seance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends MongoRepository<Seance, String> {
}
