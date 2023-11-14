package com.example.rapchieu.entity;

import lombok.Data;

@Data
public class LoginCredential {

    private String username;
    private String password;

    public LoginCredential() {
    }

    public LoginCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }
}