package com.redventures.ramengo.orders.controllers;

import com.redventures.ramengo.orders.domain.dto.BrothRequest;
import com.redventures.ramengo.orders.domain.dto.BrothView;
import com.redventures.ramengo.orders.services.impl.BrothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
