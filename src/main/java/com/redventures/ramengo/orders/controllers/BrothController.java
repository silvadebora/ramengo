package com.redventures.ramengo.orders.controllers;

import com.redventures.ramengo.orders.domain.dto.BrothView;
import com.redventures.ramengo.orders.services.impl.BrothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/broths")
public class BrothController {

    @Autowired
    private BrothService service;

    @GetMapping
    public ResponseEntity<List<BrothView>> listBroths(){
        return ResponseEntity.ok().body(service.listBroths());
    }
}
