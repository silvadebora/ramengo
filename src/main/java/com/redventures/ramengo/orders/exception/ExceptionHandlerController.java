package com.redventures.ramengo.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BrothNotFoundException.class)
    private ResponseEntity<ExceptionDetails> handlerBrothException(BrothNotFoundException ex){
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
    private ResponseEntity<ExceptionDetails> handlerProteinException(ProteinNotFoundException ex){
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
    private ResponseEntity<ExceptionDetails> handlerOrderException(OrderRequestError ex){
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

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ExceptionDetails> handlerForbiddenException(ForbiddenException ex){

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ExceptionDetails("x-api-key header missing",
                        LocalDateTime.now(),
                        HttpStatus.FORBIDDEN.value(),
                        ex.getClass().toString(), Map.of("error", ex.getMessage())));
    }
}
