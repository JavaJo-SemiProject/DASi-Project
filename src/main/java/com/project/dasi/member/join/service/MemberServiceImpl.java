package com.project.dasi.member.join.service;

import com.project.dasi.member.join.dao.MemberMapper;
import com.project.dasi.member.join.dto.MemberDTO;
import com.project.dasi.common.exception.member.MemberRegistException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;

    private final MemberMapper mapper;

    public MemberServiceImpl(PasswordEncoder passwordEncoder, MemberMapper mapper) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    /*회원 가입*/
    @Override
    @Transactional
    public void registMember(MemberDTO member) throws MemberRegistException{

        int result = mapper.insertMember(member);

        if(!(result > 0)){
            throw new MemberRegistException("회원 가입에 실패했습니다.");
        }
    }
}
