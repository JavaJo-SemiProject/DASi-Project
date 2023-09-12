package com.project.dasi.admin.memberInfo.dao;

import com.project.dasi.admin.memberInfo.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    List<UserInfoDTO> selectAllUserInfo();
}
