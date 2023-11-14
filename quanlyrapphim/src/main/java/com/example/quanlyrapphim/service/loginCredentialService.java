package com.example.quanlyrapphim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanlyrapphim.entity.LoginCredential;
import com.example.quanlyrapphim.entity.User;
import com.example.quanlyrapphim.repository.LoginCredentialRepository;

@Service
public class LoginCredentialService {

    @Autowired
    private LoginCredentialRepository loginCredentialRepository;

    public User findByLoginCredential(LoginCredential loginCredential) {
        return loginCredentialRepository.findByUsernameAndPassword(loginCredential.getUsername(), loginCredential.getPassword());
    }

    
    public User findByLoginCredential(LoginCredential loginCredential) throws Exception {
        // Tìm người dùng trong cơ sở dữ liệu bằng tên người dùng và mật khẩu
        User user = loginCredentialRepository.findByUsernameAndPassword(loginCredential.getUsername(), loginCredential.getPassword());

        // Trả về người dùng hoặc null nếu không tìm thấy người dùng
        return user;
    }
}