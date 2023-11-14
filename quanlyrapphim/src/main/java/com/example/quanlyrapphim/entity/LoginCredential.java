package com.example.quanlyrapphim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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