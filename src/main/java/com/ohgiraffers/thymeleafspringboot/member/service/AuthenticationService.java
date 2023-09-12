package com.ohgiraffers.thymeleafspringboot.member.service;

import com.ohgiraffers.thymeleafspringboot.member.dao.MemberMapper;
import com.ohgiraffers.thymeleafspringboot.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MemberMapper mapper;

    public AuthenticationService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        log.info("[AuthenticationService] =====================================================");
        log.info("[AuthenticationService] memberId : " + memberId);

        MemberDTO member = mapper.findByMemberId(memberId);

        log.info("[AuthenticationService] member : " + member);

        if(member == null){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }

        return member;
    }

}
