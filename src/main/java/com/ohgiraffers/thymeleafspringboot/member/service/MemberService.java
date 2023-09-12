package com.ohgiraffers.thymeleafspringboot.member.service;

import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberModifyException;
import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.member.MemberRemoveException;
import com.ohgiraffers.thymeleafspringboot.member.dto.MemberDTO;

public interface MemberService {

    /* 회원 조회용 메소드 */
    public boolean selectMemberById(String userId);

    /* 회원 가입용 메소드 */
    public void registMember(MemberDTO member) throws MemberRegistException;

    /* 회원 정보 수정용 메소드 */
    public void modifyMember(MemberDTO member) throws MemberModifyException;

    /* 회원 탈퇴용 메소드 */
    public void removeMember(MemberDTO member) throws MemberRemoveException;
}
