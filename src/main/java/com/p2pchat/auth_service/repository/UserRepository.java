package com.p2pchat.auth_service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.p2pchat.auth_service.entity.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUsername(String username);
}
