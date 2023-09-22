package com.project.dasi.question.controller;

import com.project.dasi.question.model.dto.QuestionDTO;
import com.project.dasi.question.model.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/content/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/questioncreate")
    public String goQuestioncreate() {
        return "content/question/questioncreate"; }


        @PostMapping("/questioncreate")
        public String Questioncreate(@ModelAttribute QuestionDTO questiondto, RedirectAttributes rttr ){
/*@ModelAttribute    이건 써도 되고 안써도 된다. 그냥 명시용임*/

            questionService.questionCreate(questiondto);
            System.out.println("check:" + questiondto);

            return "content/question/question";
        }
    }

