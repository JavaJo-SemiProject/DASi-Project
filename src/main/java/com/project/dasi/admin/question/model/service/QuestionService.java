package com.project.dasi.admin.question.model.service;

import com.project.dasi.admin.question.model.dao.QuestionMapper;
import com.project.dasi.admin.question.model.dto.QuestionDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    public QuestionDTO userselectOneQuestion(int qnumb) {

        System.out.println("qnumb service: " + qnumb);

        QuestionDTO userQuestionList = questionMapper.userquestionUpdate(qnumb);

        return userQuestionList;
    }

    public void userquestionup(QuestionDTO qdto) {

        questionMapper.userquestionup(qdto);

    }

    public void userQuestionDelete(int questionNum) {

        questionMapper.userquestionDelete(questionNum);
    }


/*    public List<QuestionService> Adminquestionupdate(questnum int questnum) {

        List<QuestionDTO> adminquestionList = questionMapper.adminquestCreate(questnum);

        return adminquestionList;

    }*/
}