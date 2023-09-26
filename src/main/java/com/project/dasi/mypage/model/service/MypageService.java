package com.project.dasi.mypage.model.service;

import com.project.dasi.auth.model.dao.UserRepository;
import com.project.dasi.mypage.model.dto.UserDTO;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setTel(user.getTel());

        return userDTO;
    }
}
