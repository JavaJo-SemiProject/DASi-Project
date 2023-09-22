package com.project.dasi.admin.question.model.service;

import com.project.dasi.admin.question.model.dao.QuestionMapper;
import com.project.dasi.admin.question.model.dto.AdminFaqDTO;
import com.project.dasi.admin.question.model.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionMapper questionmapper) {this.questionMapper = questionmapper;}


    public void questionCreate(QuestionDTO question) {

        questionMapper.questionCreate(question);

    }

    public List<QuestionDTO> SelectAllquestion() {

        List<QuestionDTO> questionList = questionMapper.questionList();

        return questionList;
    }


    public void adminQuestionCreate(QuestionDTO adminquestion) {

        questionMapper.adminquestCreate(adminquestion);
    }
}