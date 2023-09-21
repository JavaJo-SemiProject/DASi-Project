package com.project.dasi.auth.model.service.impl;

import com.project.dasi.auth.model.entity.Users;
import com.project.dasi.auth.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Users loadUserByUsername(String userid) {
        return Optional.ofNullable(userRepository.findByUserid(userid)).orElseThrow(() -> new BadCredentialsException("아이디를 확인해 주세요."));
    }

}