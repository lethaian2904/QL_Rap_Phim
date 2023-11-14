package com.example.rapchieu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rapchieu.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}
