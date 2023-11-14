package com.example.quanlyrapphim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quanlyrapphim.entity.LoginCredential;
import com.example.quanlyrapphim.entity.User;
import com.example.quanlyrapphim.service.LoginCredentialService;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private LoginCredentialService loginCredentialService;

    @PostMapping("/")
    public ResponseEntity<String> login(@RequestBody LoginCredential loginCredential) {
        try {
            User dbUser = loginCredentialService.findByLoginCredential(loginCredential);
            if (dbUser != null) {
                return new ResponseEntity<>("Đăng nhập thành công", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Tài khoản hoặc mật khẩu không chính xác", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi xác thực", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
