package com.semifir.pathe.models;

import java.time.LocalDateTime;

public class Ticket {
    String commande;
    String film;
    LocalDateTime dateDebut;
    LocalDateTime dateFin;
    int salle;

    public Ticket(String commande, String film, LocalDateTime dateDebut, LocalDateTime dateFin, int salle) {
        this.commande = commande;
        this.film = film;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.salle = salle;
    }

    public Ticket(Seance seance) {
        this.commande = seance.getId();
        this.film = seance.getFilm().getNom();
        this.dateDebut = seance.getDate();
        this.dateFin = seance.getDate().plusMinutes(seance.getFilm().getDuree());
        this.salle = seance.getSalle().getNumero();
    }

    @Override
    public String toString() {
        return  "Commande: " + commande + '\n' +
                "Film: " + film + '\n' +
                "Date de debut: " + dateDebut.toLocalDate() + " " + dateDebut.toLocalTime() + "\n" +
                "Date de fin: " + dateFin.toLocalDate() + " " + dateFin.toLocalTime() + "\n" +
                "Salle: " + salle + '\n';
    }
}
