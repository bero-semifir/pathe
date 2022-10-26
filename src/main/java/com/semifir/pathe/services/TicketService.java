package com.semifir.pathe.services;

import com.semifir.pathe.exceptions.NotFoundException;
import com.semifir.pathe.models.Seance;
import com.semifir.pathe.repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    SeanceRepository seanceRepository;

    /**
     * Génére un ticket pour à partir d'un id de séance
     * @param seanceId l'id de la séance
     * @return le ticket
     */
    public String generateTicket(String seanceId){
        // récup de la séance
        Optional<Seance> seanceOpt = this.seanceRepository.findById(seanceId);

        // vérif de l'existence de la séance
        if(seanceId.isEmpty()){
            throw new NotFoundException();
        }

        Seance seance = seanceOpt.get();
        // génération du ticket
        String ticket = "Commande: " + seanceId + "\n";
        ticket += "Cinema: " + seance.getSalle().getCinema().getNom() + "\n";
        ticket += "Film: " + seance.getFilm().getNom() + "\n";
        ticket += "Date de debut: " + seance.getDate() + "\n";
        ticket += "Date de fin: " + seance.getDate().plusMinutes(seance.getFilm().getDuree()) + "\n";
        ticket += "Salle: " + seance.getSalle().getNumero() + "\n";
        return ticket;
    }

}
