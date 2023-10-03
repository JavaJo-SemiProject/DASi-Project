package com.project.dasi.question.model.dao;

import com.project.dasi.question.model.dto.FaqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqMapper {
    List<FaqDTO> selectAllFaqList();
}
