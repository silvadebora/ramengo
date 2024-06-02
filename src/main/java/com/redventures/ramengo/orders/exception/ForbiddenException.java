package com.redventures.ramengo.orders.exception;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(String message) {
        super(message);
    }
}
