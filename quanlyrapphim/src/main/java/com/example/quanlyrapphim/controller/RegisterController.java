package com.example.quanlyrapphim.controller;

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

import com.example.quanlyrapphim.entity.LoginCredential;
import com.example.quanlyrapphim.entity.User;
import com.example.quanlyrapphim.repository.UserRepository;
import com.example.quanlyrapphim.service.UserService;


@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {

    @Autowired
    private UserService userService;
    

    @PostMapping("/")
    public ResponseEntity<User> register(@RequestBody User user) throws Exception {
        try {
        LoginCredential loginCredential = new LoginCredential(user.getUsername(), user.getPassword());
        UserRepository.save(loginCredential);

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
