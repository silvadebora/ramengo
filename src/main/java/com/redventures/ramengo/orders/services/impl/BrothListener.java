package com.redventures.ramengo.orders.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redventures.ramengo.orders.domain.Broth;
import com.redventures.ramengo.orders.repositories.BrothRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class BrothListener {

    @Autowired
    private BrothRepository brothRepository;

    private Logger LOG = LoggerFactory.getLogger(BrothListener.class);

    private final ObjectMapper mapper = new ObjectMapper();

    @SqsListener("broth")
    public void receiveBroth(@Payload String brothReceived){
        try{
            Broth broth = mapper.readValue(brothReceived, Broth.class);
            LOG.info("Received Broth ", broth);
            brothRepository.save(broth);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

