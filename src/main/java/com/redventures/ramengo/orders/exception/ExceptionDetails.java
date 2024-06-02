package com.redventures.ramengo.orders.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ExceptionDetails(String title, LocalDateTime timestamp,
                               Integer status, String exception,
                               Map<String, String> details) {
}
