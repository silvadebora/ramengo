package com.redventures.ramengo.orders.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public record ExceptionDetails(String title, LocalDateTime timestamp,
                               Integer status, String exception,
                               LinkedHashMap<String, String> details) {
}
