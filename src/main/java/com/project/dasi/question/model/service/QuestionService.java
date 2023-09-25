package com.project.dasi.question.model.service;

import com.project.dasi.admin.question.model.dao.AdminFaqMapper;
import com.project.dasi.admin.question.model.dto.AdminFaqDTO;
import com.project.dasi.question.model.dao.QuestionMapper;
import com.project.dasi.question.model.dto.QuestionDTO;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionMapper questionmapper) {this.questionMapper = questionmapper;}


    public void questionCreate(QuestionDTO question) {

        questionMapper.questionCreate(question);

    }
}