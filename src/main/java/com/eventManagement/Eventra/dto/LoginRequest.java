package com.eventManagement.Eventra.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    // Getters & Setters
    private String email;
    private String password;

    // Constructors
    public LoginRequest() {}

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

}

