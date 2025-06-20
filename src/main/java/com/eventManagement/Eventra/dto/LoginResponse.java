package com.eventManagement.Eventra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class LoginResponse {
    // Getters & Setters
    private String email;
    private String role;
    private String username;



    public LoginResponse(String email, String role, String username) {
        this.email = email;
        this.role = role;
        this.username = username;
    }
}

