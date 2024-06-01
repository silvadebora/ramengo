package com.redventures.ramengo.orders.controllers;

import com.redventures.ramengo.orders.domain.dto.OrderRequest;
import com.redventures.ramengo.orders.domain.dto.OrderView;
import com.redventures.ramengo.orders.services.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderView> order(@RequestBody OrderRequest order){
        OrderView orderView = orderService.performOrder(order);
        return ResponseEntity.ok().body(orderView);
    }
}
