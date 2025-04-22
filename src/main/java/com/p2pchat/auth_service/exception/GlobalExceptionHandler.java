package com.p2pchat.auth_service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntime(RuntimeException ex) {
        log.error("RuntimeException: {}", ex.getMessage());
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleResponseStatus(ResponseStatusException ex) {
        log.error("ResponseStatusException: {}", ex.getMessage());
        return buildResponse(
            ex.getReason() != null ? ex.getReason() : "Unexpected error",
            ex.getStatusCode()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneric(Exception ex) {
        log.error("Exception: {}", ex.getMessage(), ex);
        return buildResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Map<String, String>> buildResponse(String message, HttpStatusCode httpStatusCode) {
        Map<String, String> body = new HashMap<>();
        body.put("error", message);
        body.put("status", String.valueOf(httpStatusCode.value()));
        return ResponseEntity.status(httpStatusCode).body(body);
    }
}
