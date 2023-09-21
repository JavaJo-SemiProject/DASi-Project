package com.project.dasi.admin.memberInfo.model.service;

import com.project.dasi.admin.memberInfo.model.dao.MemberMapper;
import com.project.dasi.order.model.dto.MemberDTO;
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

    public List<MemberDTO> getMemberList(){
        List<MemberDTO> memberList = memberMapper.getMemberList();

        return memberList;
    }


}
