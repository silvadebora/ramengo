package com.redventures.ramengo.orders.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redventures.ramengo.orders.domain.Broth;
import com.redventures.ramengo.orders.repositories.BrothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BrothListener {

    @Autowired
    private BrothRepository brothRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    @SqsListener("broth")
    public void receiveBroth(@Payload String brothReceived){
        try{
            Broth broth = mapper.readValue(brothReceived, Broth.class);
            System.out.println(broth);
            brothRepository.save(broth);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

