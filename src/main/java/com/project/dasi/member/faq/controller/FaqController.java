package com.project.dasi.member.faq.controller;

import com.project.dasi.member.faq.dto.FaqDTO;
import com.project.dasi.member.faq.service.FaqServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/member/faq/*")  /*@RequestMapping과 @GetMapping은 같다 */
public class FaqController {

    private final FaqServiceImpl faqService;

    public FaqController(FaqServiceImpl faqService) {this.faqService = faqService;}
/*여기에 오토와이어드 어노테이션이 자동으로 달린다. 컨트롤러 안에 있는 단 하나의 주입이니까*/

    @GetMapping ("/faq")
    public ModelAndView faqList(ModelAndView mv) {
        List<FaqDTO> faqList = faqService.selectAllFaqList();
        mv.addObject("faqList", faqList);
        mv.setViewName("/admin/questionList/managerFaq");
        return mv;
    }
}

