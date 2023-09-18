package com.project.dasi.auth.service.impl;

import com.project.dasi.auth.dto.UserCreateRequest;
import com.project.dasi.auth.dto.UserDTO;
import com.project.dasi.auth.entity.Users;
import com.project.dasi.auth.repository.UserRepository;
import com.project.dasi.auth.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserCreateRequest userCreateRequest) {
        Users users = userRepository.save(
                Users.builder()
                        .usercode(userCreateRequest.getUsercode())
                        .userid(userCreateRequest.getUserid())
                        .password(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()))
                        .username(userCreateRequest.getUsername())
                        .birthdate(userCreateRequest.getBirthdate())
                        .email(userCreateRequest.getEmail())
                        .tel(userCreateRequest.getTel())
                        .gender(userCreateRequest.getGender())
                        .joindate(userCreateRequest.getJoindate())
                        .withdrawstatus(userCreateRequest.getWithdrawstatus())
                        .withdrawdate(userCreateRequest.getWithdrawdate())
                        .build());
        return UserDTO.builder()
                .usercode(userCreateRequest.getUsercode())
                .userid(userCreateRequest.getUserid())
                .password(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()))
                .username(userCreateRequest.getUsername())
                .birthdate(userCreateRequest.getBirthdate())
                .email(userCreateRequest.getEmail())
                .tel(userCreateRequest.getTel())
                .gender(userCreateRequest.getGender())
                .joindate(userCreateRequest.getJoindate())
                .withdrawstatus(userCreateRequest.getWithdrawstatus())
                .withdrawdate(userCreateRequest.getWithdrawdate())
                .build();
    }

    @Override
    public HashMap<String, Object> useridOverlap(String userid)
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", userRepository.existsByUserid(userid));
        return map;
    }


}
