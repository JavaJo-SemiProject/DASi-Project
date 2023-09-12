package com.ohgiraffers.thymeleafspringboot.member.service;

import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberModifyException;
import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberRemoveException;
import com.ohgiraffers.thymeleafspringboot.member.dao.MemberMapper;
import com.ohgiraffers.thymeleafspringboot.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MemberServiceImpl implements MemberService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PasswordEncoder passwordEncoder;

    private final MemberMapper mapper;

    public MemberServiceImpl(PasswordEncoder passwordEncoder, MemberMapper mapper) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    /* 회원 조회용 메소드 */
    @Override
    public boolean selectMemberById(String userId) {

        String result = mapper.selectMemberById(userId);

        return result != null? true : false;
    }

    /* 회원 가입용 메소드 */
    @Override
    @Transactional
    public void registMember(MemberDTO member) throws MemberRegistException{

        log.info("[MemberService] Insert Member : " + member);
        int result = mapper.insertMember(member);

        log.info("[MemberService] Insert result : " + ((result > 0) ? "회원가입 성공" : "회원가입 실패"));

        if(!(result > 0 )){
            throw new MemberRegistException("회원 가입에 실패하였습니다.");
        }
    }

    /* 회원 정보 수정용 메소드 */
    @Override
    public void modifyMember(MemberDTO member) throws MemberModifyException {
        int result = mapper.updateMember(member);

        if(!(result > 0)) {
            throw new MemberModifyException("회원 정보 수정에 실패하셨습니다.");
        }
    }

    /* 회원 탈퇴용 메소드 */
    @Override
    public void removeMember(MemberDTO member) throws MemberRemoveException {
        int result = mapper.deleteMember(member);

        if(!(result > 0)) {
            throw new MemberRemoveException("회원 탈퇴에 실패하셨습니다.");
        }
    }
}
