package com.redventures.ramengo.orders.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.redventures.ramengo.orders.domain.Protein;
import com.redventures.ramengo.orders.domain.dto.ProteinView;
import com.redventures.ramengo.orders.repositories.ProteinRepository;
import com.redventures.ramengo.orders.services.IProteinService;
import com.redventures.ramengo.orders.util.ProteinConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProteinService implements IProteinService {

    @Autowired
    private ProteinRepository proteinRepository;


    @Override
    public List<ProteinView> listProteins() {
        var proteins = proteinRepository.findAll();
        return proteins.stream().map(ProteinConverter::toView).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity saveProtein(Object protein) {
        Gson gson = new Gson();
        Protein proteinEntity;
        try{
            proteinEntity = gson.fromJson(protein.toString(), Protein.class);
            proteinRepository.save(proteinEntity);
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(proteinEntity);
    }


}
