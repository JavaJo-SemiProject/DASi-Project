package com.project.dasi.admin.memberInfo.model.dao;

import com.github.pagehelper.Page;
import com.project.dasi.admin.memberInfo.model.dto.MemberDTO;
import com.project.dasi.admin.memberInfo.model.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    List<MemberDTO> getMemberList();
    int registMember(MemberDTO newMember);
    Page<MemberDTO> searchMember(SearchDTO search);
    void modifyMember(MemberDTO member);

    int deleteMember(Map<String, String> parameter);
}

