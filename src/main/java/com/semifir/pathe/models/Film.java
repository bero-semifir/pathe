package com.semifir.pathe.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Film {
    @Id
    private String id;
    private String nom;
    private int duree;
}
