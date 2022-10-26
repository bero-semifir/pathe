package com.semifir.pathe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Cinema {
    @Id
    String id;
    String nom;

    @DBRef
    List<Salle> salles;
    @DBRef
    List<Seance> seances;
}
