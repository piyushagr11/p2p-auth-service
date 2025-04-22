package com.p2pchat.auth_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsernameAlreadyExistsException extends ResponseStatusException {
    public UsernameAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Username already exists");
    }
}