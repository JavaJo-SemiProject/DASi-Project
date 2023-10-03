package com.project.dasi.mypage.model.service;

import com.project.dasi.auth.model.dao.UserMapper;
import com.project.dasi.auth.model.dao.UserRepository;

import com.project.dasi.auth.model.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class MypageService {

    @Autowired
    private UserMapper userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO getUserInfo(String userId) {
        System.out.println("userId service" + userId);

        UserDTO userDTO = userRepository.findUserByUserId(userId); // UserDTO로 사용자 정보를 가져온다.
        return userDTO;
    }

    public void updatePassword(String userId, String newPassword) {
        // 비밀번호를 암호화하여 저장
        String encodedPassword = passwordEncoder.encode(newPassword);
        userRepository.updatePassword(userId, encodedPassword);
    }

}
