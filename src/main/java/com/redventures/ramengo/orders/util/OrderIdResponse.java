package com.redventures.ramengo.orders.util;

public class OrderIdResponse{

    private String orderId;

    public OrderIdResponse() {
    }

    public OrderIdResponse(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
