package com.project.dasi.admin.memberInfo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.dasi.admin.memberInfo.dao.MemberMapper;
import com.project.dasi.admin.memberInfo.dto.MemberDTO;
import com.project.dasi.admin.memberInfo.dto.SearchDTO;
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

    @Transactional
    public void registMember(MemberDTO newMember) {
        memberMapper.registMember(newMember);
    }

    public Page<MemberDTO> getUserList(int pageNum, SearchDTO search) throws Exception {
        PageHelper.startPage(pageNum, 10);
        return memberMapper.findUser(search);
    }

}
