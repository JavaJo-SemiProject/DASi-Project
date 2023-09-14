package com.project.dasi.admin.memberInfo.dao;

import com.project.dasi.admin.memberInfo.dto.Criteria;
import com.project.dasi.admin.memberInfo.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDTO> getMemberList();
    int registMember(MemberDTO newMember);



}

