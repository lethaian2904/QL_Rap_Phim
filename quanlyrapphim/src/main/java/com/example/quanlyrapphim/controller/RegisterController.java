package com.example.rapchieu.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rapchieu.entity.LoginCredential;
import com.example.rapchieu.entity.User;
import com.example.rapchieu.service.UserService;
import com.example.rapchieu.repository.LoginCredentialRepository;


@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginCredentialRepository loginCredentialRepository;

    @PostMapping("/")
    public ResponseEntity<User> register(@RequestBody User user) throws Exception {
    try {
       
        LoginCredential loginCredential = new LoginCredential(user.getUsername(), user.getPassword());
        loginCredentialRepository.save(loginCredential);

        // Lưu trữ thông tin người dùng vào cơ sở dữ liệu
        userService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (SQLException e) {
        throw e;
    }
}

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleSQLException(SQLException e) {
        return new ResponseEntity<>("Lỗi kết nối đến cơ sở dữ liệu", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
