package com.semifir.pathe.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Seance {
    @Id
    String id;
    LocalDateTime date;

    @DBRef
    Film film;

    @DBRef
    Salle salle;
}
