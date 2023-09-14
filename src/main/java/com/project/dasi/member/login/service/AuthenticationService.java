package com.project.dasi.member.login.service;

import com.project.dasi.member.join.dao.MemberMapper;
import com.project.dasi.member.join.dto.MemberDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private final MemberMapper mapper;

    public AuthenticationService(MemberMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{

        MemberDTO user = mapper.findByuserId(userId);

        if(user == null){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        return user;
    }
}
