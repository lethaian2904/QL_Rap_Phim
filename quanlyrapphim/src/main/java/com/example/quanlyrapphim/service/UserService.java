package com.example.quanlyrapphim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanlyrapphim.entity.LoginCredential;
import com.example.quanlyrapphim.entity.User;
import com.example.quanlyrapphim.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByLoginCredential(LoginCredential loginCredential) throws Exception {
        // Tìm người dùng theo tên người dùng và mật khẩu
        User user = userRepository.findByUsernameAndPassword(loginCredential.getUsername(), loginCredential.getPassword());

        // Nếu người dùng không tồn tại trong cơ sở dữ liệu, ném ngoại lệ
        if (user == null) {
            throw new Exception("Người dùng không tồn tại");
        }

        // Trả về đối tượng User
        return user;
    }

    public User save(User user) throws Exception {
        // Lưu trữ thông tin người dùng vào cơ sở dữ liệu
        userRepository.save(user);

        // Trả về đối tượng User
        return user;
    }

    public User findByUsername(String username) throws Exception {
        // Tìm người dùng theo tên người dùng
        User user = userRepository.findByUsername(username);

        // Nếu người dùng không tồn tại trong cơ sở dữ liệu, ném ngoại lệ
        if (user == null) {
            throw new Exception("Người dùng không tồn tại");
        }

        // Trả về đối tượng User
        return user;
    }
}
