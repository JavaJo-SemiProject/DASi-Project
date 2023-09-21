package com.project.dasi.member.join.service;

import com.project.dasi.common.exception.member.MemberRegistException;
import com.project.dasi.member.join.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface MemberService {

    /*회원가입 메소드*/
    public void registMember(MemberDTO member) throws MemberRegistException;
}
