package com.project.dasi.question.model.dao;

import com.project.dasi.question.model.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    void questionCreate(QuestionDTO question);
}
