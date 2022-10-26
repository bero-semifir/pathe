package com.semifir.pathe.controllers;

import com.semifir.pathe.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tickets")
public class TicketController {

    @Autowired
    TicketService service;

    @GetMapping("{seanceId}")
    public String getTicket(@PathVariable String seanceId){
        return this.service.generateTicket(seanceId);
    }
}
