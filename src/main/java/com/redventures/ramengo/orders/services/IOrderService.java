package com.redventures.ramengo.orders.services;

import com.redventures.ramengo.orders.domain.Order;
import com.redventures.ramengo.orders.domain.dto.OrderRequest;
import com.redventures.ramengo.orders.domain.dto.OrderView;

import java.math.BigDecimal;

public interface IOrderService {

    OrderView performOrder(OrderRequest order);

    BigDecimal calculateTotalValue(Order order);

    void populateOrderDescription(Order order);
}
