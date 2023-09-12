package com.project.dasi.admin.memberInfo.service;

import com.project.dasi.admin.memberInfo.dao.UserInfoMapper;
import com.project.dasi.admin.memberInfo.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private final UserInfoMapper userInfoMapper;

    public UserInfoService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public List<UserInfoDTO> selectAllUserInfo() {
        return userInfoMapper.selectAllUserInfo();
    }


}
