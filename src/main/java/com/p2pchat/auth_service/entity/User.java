package com.p2pchat.auth_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Document(collection = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    
    private String username;
    private String password;
}
