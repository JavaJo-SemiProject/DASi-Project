package com.project.dasi.question.controller;

import com.project.dasi.admin.question.model.dto.QuestionDTO;
import com.project.dasi.question.model.dto.FaqDTO;
import com.project.dasi.question.model.service.FaqService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/content/question")
public class FaqController {

    private final FaqService faqService;

    public FaqController(FaqService faqService) {this.faqService = faqService;}


    @GetMapping ("/faq")
    public String faqList(Model model) {
        List<FaqDTO> faqList = faqService.selectAllFaqList();
        model.addAttribute("faqList", faqList);
        return "content/question/faq";

    }


}