package com.example.quanlyrapphim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlyrapphim.entity.LoginCredential;
import com.example.quanlyrapphim.entity.User;

public interface LoginCredentialRepository extends JpaRepository<LoginCredential, Long> {

    LoginCredential findByUsername(String username);
    
    User findByUsernameAndPassword(String username, String password);
    
}

