package com.project.dasi.auth.service.impl;

import com.project.dasi.auth.dto.UserCreateRequest;
import com.project.dasi.auth.dto.UserDTO;
import com.project.dasi.auth.entity.Users;
import com.project.dasi.auth.repository.UserRepository;
import com.project.dasi.auth.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserCreateRequest userCreateRequest) {
        Users users = userRepository.save(
                Users.builder().userid(userCreateRequest.getUserid()).password(bCryptPasswordEncoder.encode(userCreateRequest.getPassword())).email(userCreateRequest.getEmail()).userrole(userCreateRequest.getUserrole()).build());
        return UserDTO.builder().userid(users.getUserid()).password(users.getPassword()).email(users.getEmail()).userrole(users.getUserrole()).build();
    }

}
