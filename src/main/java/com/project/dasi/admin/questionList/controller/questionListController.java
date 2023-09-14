package com.project.dasi.admin.questionList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class questionListController {
    @RequestMapping("/admin/questionList/managerFaq")
    public void goManagerFaq() {}

    @RequestMapping("/admin/questionList/managerFaq")
    public String managerInfo(){

    }


    @RequestMapping("/admin/questionList/managerFaqCreate")
    public void goManagerFaqCreate() {}
    @RequestMapping("/admin/questionList/managerFaqUpdate")
    public void goManagerFaqUpdate() {}
    @RequestMapping("/admin/questionList/managerQuestion")
    public void goManagerQuestion() {}
    @RequestMapping("/admin/questionList/managerQuestionCreate")
    public void goManagerQuestionCreate() {}


}
