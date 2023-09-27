package com.project.dasi.mypage.model.service;

import com.project.dasi.auth.model.dao.UserMapper;
import com.project.dasi.auth.model.dao.UserRepository;

import com.project.dasi.auth.model.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MypageService {

    @Autowired
    private UserMapper userRepository;

    public UserDTO getUserInfo(String userId) {
        System.out.println("userId service" + userId);

        UserDTO userDTO = userRepository.findUserByUserId(userId); // UserDTO로 사용자 정보를 가져온다.
        return userDTO;
    }

}
