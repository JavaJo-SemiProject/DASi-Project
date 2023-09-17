package com.project.dasi.admin.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class questionController {
    @RequestMapping("/admin/question/managerFaq")
    public void goManagerFaq() {}
    @RequestMapping("/admin/question/managerFaqCreate")
    public void goManagerFaqCreate() {}
    @RequestMapping("/admin/question/managerFaqUpdate")
    public void goManagerFaqUpdate() {}
    @RequestMapping("/admin/question/managerQuestion")
    public void goManagerQuestion() {}
    @RequestMapping("/admin/question/managerQuestionCreate")
    public void goManagerQuestionCreate() {}
}
