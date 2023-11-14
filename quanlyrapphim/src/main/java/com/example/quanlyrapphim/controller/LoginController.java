package com.example.quanlyrapphim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.quanlyrapphim.entity.LoginCredential;
import com.example.quanlyrapphim.entity.User;
import com.example.quanlyrapphim.service.UserService;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<String> login(@RequestBody LoginCredential loginCredential) throws Exception {
        try {
            User dbUser = userService.findByUsernameAndPassword(loginCredential.getUsername(), loginCredential.getPassword());
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
