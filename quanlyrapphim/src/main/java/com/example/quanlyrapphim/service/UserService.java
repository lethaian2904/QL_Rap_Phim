package com.example.rapchieu.service;

import com.example.rapchieu.entity.User;
import com.example.rapchieu.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsernameAndPassword(String username, String password) throws Exception {
        // Tìm người dùng theo tên người dùng và mật khẩu
        User user = userRepository.findByUsernameAndPassword(username, password);

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