package com.project.dasi.admin.memberInfo.service;

import com.project.dasi.admin.memberInfo.dao.MemberMapper;
import com.project.dasi.admin.memberInfo.dto.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<MemberDTO> getMemberList(){
        List<MemberDTO> memberList = memberMapper.getMemberList();

        return memberList;
    }

    public List<MemberDTO> getMemberListByCondition(){
        List<MemberDTO> memberList = memberMapper.getMemberListByCondition();

        return memberList;
    }

    @Transactional
    public void registMember(MemberDTO newMember) {
        memberMapper.registMember(newMember);
    }

}
