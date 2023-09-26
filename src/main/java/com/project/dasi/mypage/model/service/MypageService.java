package com.project.dasi.mypage.model.service;

import com.project.dasi.auth.model.dao.UserRepository;

import com.project.dasi.auth.model.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MypageService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserInfo(String userId) {
        User user = userRepository.findByUsername(userId);
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userDTO.getUserId());
        userDTO.setName(userDTO.getName());
        userDTO.setEmail(userDTO.getEmail());
        userDTO.setTel(userDTO.getTel());

        return userDTO;
    }
}
