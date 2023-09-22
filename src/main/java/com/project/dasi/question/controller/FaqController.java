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
@RequestMapping("/content/question")  /*@RequestMapping과 @GetMapping은 같다 */
public class FaqController {

    private final FaqService faqService;



    public FaqController(FaqService faqService) {this.faqService = faqService;}
    /*여기에 오토와이어드 어노테이션이 자동으로 달린다. 컨트롤러 안에 있는 단 하나의 주입이니까*/




    @GetMapping ("/faq")
    public String faqList(Model model) {
        List<FaqDTO> faqList = faqService.selectAllFaqList();
        model.addAttribute("faqList", faqList);
        return "content/question/faq";   /*뷰단에 보여주는거라서 여기서 작성한주소는 templete하위의 것들이다*/ /*앞에 /붙이지 말고!*/

    }



}