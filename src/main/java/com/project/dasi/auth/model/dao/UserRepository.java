package com.project.dasi.auth.model.dao;

import com.project.dasi.auth.model.dto.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private final PasswordEncoder passwordEncoder;

    public UserRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public UserDTO loadUserByUsername(String userId) {
        UserDTO userDTO = null;

        String password = passwordEncoder.encode(userDTO.getPassword());

        userDTO.getUserId();
        userDTO.getPassword();

        return userDTO;
    }

}