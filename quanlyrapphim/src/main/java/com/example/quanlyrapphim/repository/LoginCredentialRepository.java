package com.example.rapchieu.repository;

import com.example.rapchieu.entity.LoginCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginCredentialRepository extends JpaRepository<LoginCredential, Long> {

    LoginCredential findByUsername(String username);
}