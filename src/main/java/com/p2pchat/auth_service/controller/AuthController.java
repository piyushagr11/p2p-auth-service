package com.p2pchat.auth_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p2pchat.auth_service.dto.AuthResponse;
import com.p2pchat.auth_service.dto.LoginRequest;
import com.p2pchat.auth_service.dto.RegisterRequest;
import com.p2pchat.auth_service.service.AuthService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public Mono<ResponseEntity<Void>> register(@RequestBody RegisterRequest request) {
        return authService.register(request)
                .thenReturn(ResponseEntity.ok().build());
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody LoginRequest request) {
        return authService.login(request)
                .map(ResponseEntity::ok);
    }
}
