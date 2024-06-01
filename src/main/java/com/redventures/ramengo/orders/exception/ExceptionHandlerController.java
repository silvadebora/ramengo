package com.redventures.ramengo.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BrothNotFoundException.class)
    private ResponseEntity<ExceptionDetails> handlerValidException(BrothNotFoundException ex){
        LinkedHashMap<String, String> details = new LinkedHashMap<>();
        if (ex.getCause() != null) {
            details.put("cause", ex.getCause().toString());
        }
        if (ex.getMessage() != null) {
            details.put("message", ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDetails("Broth not found", LocalDateTime.now(),
                                HttpStatus.NOT_FOUND.value(), ex.getClass().toString(), details)
                );

    }

    @ExceptionHandler(ProteinNotFoundException.class)
    private ResponseEntity<ExceptionDetails> handlerValidException(ProteinNotFoundException ex){
        LinkedHashMap<String, String> details = new LinkedHashMap<>();
        if (ex.getCause() != null) {
            details.put("cause", ex.getCause().toString());
        }
        if (ex.getMessage() != null) {
            details.put("message", ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDetails("Protein not found", LocalDateTime.now(),
                                HttpStatus.NOT_FOUND.value(), ex.getClass().toString(), details)
                );

    }

    @ExceptionHandler(OrderRequestError.class)
    private ResponseEntity<ExceptionDetails> handlerValidException(OrderRequestError ex){
        LinkedHashMap<String, String> details = new LinkedHashMap<>();
        if (ex.getCause() != null) {
            details.put("cause", ex.getCause().toString());
        }
        if (ex.getMessage() != null) {
            details.put("message", ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDetails("Both brothId and proteinId are required", LocalDateTime.now(),
                                HttpStatus.NOT_FOUND.value(), ex.getClass().toString(), details)
                );

    }
}
