package com.redventures.ramengo.orders.services.impl;

import com.redventures.ramengo.orders.domain.dto.ProteinView;
import com.redventures.ramengo.orders.repositories.ProteinRepository;
import com.redventures.ramengo.orders.services.IProteinService;
import com.redventures.ramengo.orders.util.ProteinConverter;
import org.springframework.beans.factory.annotation.Autowired;
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
}
