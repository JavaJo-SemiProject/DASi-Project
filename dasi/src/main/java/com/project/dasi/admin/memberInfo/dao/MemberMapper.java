package com.project.dasi.admin.memberInfo.dao;

import com.github.pagehelper.Page;
import com.project.dasi.admin.memberInfo.dto.MemberDTO;
import com.project.dasi.admin.memberInfo.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDTO> getMemberList();
    int registMember(MemberDTO newMember);

    Page<MemberDTO> findUser(SearchDTO search);

}

