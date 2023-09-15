package com.project.dasi.admin.question.controller;


import com.project.dasi.question.model.dto.FaqDTO;
import com.project.dasi.question.model.service.FaqService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/question")
public class QuestionListController {

    private final FaqService faqService;

    public QuestionListController(FaqService faqService) {
        this.faqService = faqService;
    }


    @GetMapping("/faq")
    public String goManagerFaq(Model model) {
        List<FaqDTO> faqList = faqService.selectAllFaqList();
        model.addAttribute("faqList", faqList);
        return "admin/question/faq";

    }

    @GetMapping ("faq/create")
    public void goManagerFaqCreate() {}
    @RequestMapping("/admin/question/managerFaqUpdate")
    public void goManagerFaqUpdate() {}
    @RequestMapping("/admin/question/managerQuestion")
    public void goManagerQuestion() {}
    @RequestMapping("/admin/question/managerQuestionCreate")
    public void goManagerQuestionCreate() {}
}


