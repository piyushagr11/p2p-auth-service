package com.p2pchat.auth_service.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.p2pchat.auth_service.dto.AuthResponse;
import com.p2pchat.auth_service.dto.LoginRequest;
import com.p2pchat.auth_service.dto.RegisterRequest;
import com.p2pchat.auth_service.entity.User;
import com.p2pchat.auth_service.exception.InvalidTokenException;
import com.p2pchat.auth_service.exception.UsernameAlreadyExistsException;
import com.p2pchat.auth_service.repository.UserRepository;
import com.p2pchat.auth_service.security.JwtUtil;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public Mono<Void> register(RegisterRequest request) {
        return userRepository.findByUsername(request.username())
                .flatMap(existing -> Mono.error(new UsernameAlreadyExistsException()))
                .switchIfEmpty(
                        userRepository.save(
                                User.builder()
                                        .username(request.username())
                                        .password(passwordEncoder.encode(request.password()))
                                        .build()
                        )
                ).thenEmpty(Mono.empty());
    	    }

    public Mono<AuthResponse> login(LoginRequest request) {
        return userRepository.findByUsername(request.username())
                .switchIfEmpty(Mono.error(new InvalidTokenException()))
                .flatMap(user -> {
                    if (passwordEncoder.matches(request.password(), user.getPassword())) {
                        String token = jwtUtil.generateToken(user.getUsername());
                        return Mono.just(new AuthResponse(token));
                    } else {
                        return Mono.error(new InvalidTokenException());
                    }
                });
    }
}