package com.project.dasi.member.faq.dao;

import com.project.dasi.member.faq.dto.FaqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqMapper {
    List<FaqDTO> selectAllFaqList();
}
