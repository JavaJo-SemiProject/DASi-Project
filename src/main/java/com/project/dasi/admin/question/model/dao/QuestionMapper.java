package com.project.dasi.admin.question.model.dao;

import com.project.dasi.admin.question.model.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    int adminquestCreate(QuestionDTO question);

    List<QuestionDTO> questionList();

    void questionCreate(QuestionDTO question);
}
