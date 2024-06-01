package com.redventures.ramengo.orders.exception;

public class OrderRequestError extends RuntimeException{

    public OrderRequestError(String message) {
        super(message);
    }
}
