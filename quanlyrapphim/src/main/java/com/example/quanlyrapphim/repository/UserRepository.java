package com.example.quanlyrapphim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlyrapphim.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}
