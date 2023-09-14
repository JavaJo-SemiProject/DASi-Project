package com.project.dasi.admin.questionList.controller;

import com.project.dasi.member.faq.controller.FaqController;
import com.project.dasi.member.faq.dto.FaqDTO;
import com.project.dasi.member.faq.service.FaqService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class questionListController {
    @RequestMapping("/admin/questionList/managerFaq")
    public void goManagerFaq() {}

    @RequestMapping("/admin/questionList/managerFaqCreate")
    public void goManagerFaqCreate() {}
    @RequestMapping("/admin/questionList/managerFaqUpdate")
    public void goManagerFaqUpdate() {}
    @RequestMapping("/admin/questionList/managerQuestion")
    public void goManagerQuestion() {}
    @RequestMapping("/admin/questionList/managerQuestionCreate")
    public void goManagerQuestionCreate() {}
}
