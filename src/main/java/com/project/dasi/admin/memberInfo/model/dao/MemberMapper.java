package com.project.dasi.admin.memberInfo.model.dao;


import com.github.pagehelper.Page;
import com.project.dasi.admin.memberInfo.model.dto.SearchDTO;
import com.project.dasi.auth.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    Page<UserDTO> searchMember(SearchDTO search);

    int registMember(UserDTO newMember);

    void modifyMember(UserDTO member);

    int deleteMember(Map<String, String> parameter);

}