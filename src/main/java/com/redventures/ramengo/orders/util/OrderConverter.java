package com.redventures.ramengo.orders.util;

import com.redventures.ramengo.orders.domain.Order;
import com.redventures.ramengo.orders.domain.dto.OrderRequest;
import com.redventures.ramengo.orders.domain.dto.OrderView;

public class OrderConverter {

    public static Order toEntity(OrderRequest order){
        return new Order(order.getBrothId(), order.getProteinId());
    }

    public static OrderView toView(Order order){
        String description = String.join(", ", order.getDescription());
        return new OrderView(order.getId(), description, order.getImage(), order.getAmount());
    }
}
