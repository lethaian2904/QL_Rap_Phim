package com.example.rapchieu.controller;

import com.example.rapchieu.entity.User;
import com.example.rapchieu.service.UserService;

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

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<String> login(@RequestBody User user) throws Exception {
        try {
            User dbUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (dbUser != null) {
                return new ResponseEntity<>("Đăng nhập thành công", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Tài khoản hoặc mật khẩu không chính xác", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
