package com.project.dasi.auth.service.impl;

import com.project.dasi.auth.entity.Users;
import com.project.dasi.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import java.util.Optional;

@RequiredArgsConstructor
@Service
class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Users loadUserByUsername(String userid) {
        return Optional.ofNullable(userRepository.findByUserid(userid)).orElseThrow(() -> new BadCredentialsException("아이디를 확인해 주세요."));
    }

}