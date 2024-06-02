package com.redventures.ramengo.orders.services.impl;

import com.redventures.ramengo.orders.domain.Order;
import com.redventures.ramengo.orders.domain.dto.OrderRequest;
import com.redventures.ramengo.orders.domain.dto.OrderView;
import com.redventures.ramengo.orders.exception.BrothNotFoundException;
import com.redventures.ramengo.orders.exception.OrderRequestError;
import com.redventures.ramengo.orders.exception.ProteinNotFoundException;
import com.redventures.ramengo.orders.repositories.BrothRepository;
import com.redventures.ramengo.orders.repositories.OrderRepository;
import com.redventures.ramengo.orders.repositories.ProteinRepository;
import com.redventures.ramengo.orders.services.IOrderService;
import com.redventures.ramengo.orders.util.OrderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BrothRepository brothRepository;

    @Autowired
    private ProteinRepository proteinRepository;

    @Autowired
    private GenerateOrderIdService generateOrderIdService;

    @Override
    public OrderView performOrder(OrderRequest order) {
        if(order.getBrothId() == null || order.getProteinId() == null){
            throw new OrderRequestError("Both brothId and proteinId are required");
        }
        String orderId = generateOrderIdService.generateOrderId();
        Order orderEntity = OrderConverter.toEntity(order);
        orderEntity.setId(orderId);
        calculateTotalValue(orderEntity);
        populateOrderDescription(orderEntity);
        orderRepository.save(orderEntity);
        return OrderConverter.toView(orderEntity);
    }

    @Override
    public void calculateTotalValue(Order order) {
        var totalValue = BigDecimal.ZERO;
        var broth = brothRepository.findById(order.getBrothId().getId())
                .orElseThrow(() -> new BrothNotFoundException("Broth not found"));
        totalValue = totalValue.add(broth.getPrice());
        var protein = proteinRepository.findById(order.getProteinId().getId())
                .orElseThrow(() -> new ProteinNotFoundException("Protein not found"));
        totalValue = totalValue.add(protein.getPrice());
        order.setAmount(totalValue);
    }

    @Override
    public void populateOrderDescription(Order order) {
        List<String> description = new ArrayList<>();
        var broth = brothRepository.findById(order.getBrothId().getId()).orElseThrow();
        description.add(broth.getName());
        var protein = proteinRepository.findById(order.getProteinId().getId()).orElseThrow();
        description.add(protein.getName());
        order.setDescription(description);
    }


}
