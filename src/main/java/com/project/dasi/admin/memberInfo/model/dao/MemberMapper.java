package com.project.dasi.admin.memberInfo.model.dao;


import com.project.dasi.order.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    List<MemberDTO> getMemberList();
}

