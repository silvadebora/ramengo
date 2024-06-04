package com.redventures.ramengo.orders.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redventures.ramengo.orders.domain.Protein;
import com.redventures.ramengo.orders.repositories.ProteinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ProteinListener {

    @Autowired
    private ProteinRepository proteinRepository;

    private Logger LOG = LoggerFactory.getLogger(ProteinListener.class);

    private final ObjectMapper mapper = new ObjectMapper();

    @SqsListener("protein")
    public void receiveProtein(@Payload String proteinReceived){
        try{
            Protein protein = mapper.readValue(proteinReceived, Protein.class);
            proteinRepository.save(protein);
            LOG.info("Received Protein ", protein);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
