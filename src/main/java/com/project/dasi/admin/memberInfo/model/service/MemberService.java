package com.project.dasi.admin.memberInfo.model.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.dasi.admin.memberInfo.model.dao.MemberMapper;
import com.project.dasi.admin.memberInfo.model.dto.SearchDTO;

import com.project.dasi.auth.model.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<UserDTO> getMemberList(){
        List<UserDTO> memberList = memberMapper.getMemberList();

        return memberList;
    }

    @Transactional
    public void registMember(UserDTO newMember) {
        memberMapper.registMember(newMember);
    }

    @Transactional
    public void modifyMember(UserDTO member) {
        memberMapper.modifyMember(member);
    }

    public Page<UserDTO> searchMember(int pageNum, SearchDTO search) throws Exception {
        PageHelper.startPage(pageNum, 10);
        return memberMapper.searchMember(search);
    }

    @Transactional
    public void deleteMember(Map<String, String> parameter) {
        memberMapper.deleteMember(parameter);
    }
}