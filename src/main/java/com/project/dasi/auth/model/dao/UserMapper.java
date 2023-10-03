package com.project.dasi.auth.model.dao;

import com.github.pagehelper.Page;
import com.project.dasi.admin.memberInfo.model.dto.SearchDTO;

import com.project.dasi.auth.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    // 로그인
    UserDTO getMemberList(String userId);

    // 회원가입
    void registMember(UserDTO member);

    UserDTO findUserByUserId(String userId);

    Page<UserDTO> searchMember(SearchDTO search);

    void modifyMember(UserDTO member);

    int deleteMember(Map<String, String> parameter);

    int idCheck(String userId);

    int emailCheck(String email);

    Integer idAndEmailCheck(String userId, String email);

    void modifyPassword(UserDTO member);
    void updatePassword(String userId, String encodedPassword);


}