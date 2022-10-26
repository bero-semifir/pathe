package com.semifir.pathe.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Salle {
    @Id
    String id;
    int numero;
    int nbPlaces;
    @DBRef
    Cinema cinema;
}
