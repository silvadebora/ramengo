package com.redventures.ramengo.orders.controllers;


import com.redventures.ramengo.orders.domain.dto.BrothRequest;
import com.redventures.ramengo.orders.domain.dto.ProteinRequest;
import com.redventures.ramengo.orders.domain.dto.ProteinView;
import com.redventures.ramengo.orders.services.impl.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proteins")
public class ProteinController {

    @Autowired
    private ProteinService service;

    @GetMapping
    public ResponseEntity<List<ProteinView>> listProteins(){
        return ResponseEntity.ok().body(service.listProteins());
    }
}
