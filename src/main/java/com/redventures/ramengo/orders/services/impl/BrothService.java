package com.redventures.ramengo.orders.services.impl;

import com.google.gson.Gson;
import com.redventures.ramengo.orders.domain.Broth;
import com.redventures.ramengo.orders.domain.Protein;
import com.redventures.ramengo.orders.domain.dto.BrothView;
import com.redventures.ramengo.orders.repositories.BrothRepository;
import com.redventures.ramengo.orders.services.IBrothService;
import com.redventures.ramengo.orders.util.BrothConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrothService implements IBrothService {

    @Autowired
    private BrothRepository brothRepository;

    @Override
    public List<BrothView> listBroths() {
        var broths = brothRepository.findAll();
        return broths.stream().map(BrothConverter::toView).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity saveBroth(Object broth) {
        Gson gson = new Gson();
        Broth brothEntity;
        try{
            brothEntity = gson.fromJson(broth.toString(), Broth.class);
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(brothEntity);
    }
}
