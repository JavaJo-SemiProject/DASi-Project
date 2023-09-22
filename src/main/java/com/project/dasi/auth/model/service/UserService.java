package com.project.dasi.auth.model.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.dasi.admin.memberInfo.model.dto.SearchDTO;
import com.project.dasi.auth.model.dao.UserMapper;
import com.project.dasi.auth.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    private final UserMapper userMapper;

    @Transactional
    public void registMember(UserDTO member){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        userMapper.registMember(member);
    }

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        log.info("## loadUserByUsername ##");

        UserDTO userDTO = userMapper.findUserByUserId(userId);

        if( userDTO == null ) {
            log.debug("## 계정정보가 존재하지 않습니다. ##");
            throw new UsernameNotFoundException(userId);
        }
        return userDTO;
    }

    @Transactional
    public void modifyMember(UserDTO member) {
        userMapper.modifyMember(member);
    }

    public Page<UserDTO> searchMember(int pageNum, SearchDTO search) throws Exception {
        PageHelper.startPage(pageNum, 10);
        return userMapper.searchMember(search);
    }

    @Transactional
    public void deleteMember(Map<String, String> parameter) {
        userMapper.deleteMember(parameter);
    }

    public int idCheck(String userId) {
        int cnt = userMapper.idCheck(userId);
        System.out.println("cnt: " + cnt);
        return cnt;
    }

}