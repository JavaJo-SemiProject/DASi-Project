package com.project.dasi.member.join.dao;

import com.project.dasi.member.join.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    String selectuserId(String userId);

    int insertMember(MemberDTO member);


    MemberDTO selectMember(MemberDTO member);
    MemberDTO findByuserId(String userId);

}
