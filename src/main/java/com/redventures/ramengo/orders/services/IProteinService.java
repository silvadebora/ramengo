package com.redventures.ramengo.orders.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.redventures.ramengo.orders.domain.dto.ProteinView;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProteinService {

    List<ProteinView> listProteins();
    ResponseEntity saveProtein(Object protein) throws JsonProcessingException;
}
