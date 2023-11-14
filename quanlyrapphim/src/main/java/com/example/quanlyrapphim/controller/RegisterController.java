package com.example.quanlyrapphim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.quanlyrapphim.entity.LoginCredential;
import com.example.quanlyrapphim.entity.User;
import com.example.quanlyrapphim.service.UserService;

@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> register(@RequestBody LoginCredential loginCredential) throws Exception {
        if (loginCredential == null) {
            throw new IllegalArgumentException("The login credential object cannot be null");
        }

        User user = userService.registerUser(loginCredential);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Lỗi không xác định", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}