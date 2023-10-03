package com.project.dasi.admin.question.controller;


import com.project.dasi.admin.question.model.dto.AdminFaqDTO;
import com.project.dasi.admin.question.model.dto.QuestionDTO;
import com.project.dasi.admin.question.model.service.AdminFaqService;
import com.project.dasi.admin.question.model.service.QuestionService;
import com.project.dasi.mypage.model.service.MypageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = {"/admin/question", "/content/question"})
public class AdminfqController {

    private final AdminFaqService adminFaqService;

    private final QuestionService questionService;



    public AdminfqController(AdminFaqService adminFaqService, QuestionService questionService) {
        this.adminFaqService = adminFaqService;
        this.questionService = questionService;

    }


    @GetMapping("/managerFaq")
    public String goManagerFaq(Model model) {
        List<AdminFaqDTO> faqList = adminFaqService.adminSelectAllFaqList();
        model.addAttribute("faqList", faqList);
        return "admin/question/managerFaq";
    }

    @GetMapping("/managerFaqUpdate/{Num}")
    public String goManagerFaqUpdate(Model model, @PathVariable("Num") int no) {

        AdminFaqDTO faqList = adminFaqService.adminSelectOneFaqList(no);
        model.addAttribute("faqList", faqList);
        return "admin/question/managerFaqUpdate";
    }


    @PostMapping("/managerFaqUpdate/{faqNum}")
    public String managerFaqUpdateRegist(AdminFaqDTO adminfaq, RedirectAttributes rttr) {

        adminFaqService.adminFaqUpdateRegist(adminfaq);
        System.out.println("check:" + adminfaq);


        rttr.addFlashAttribute("message", "FaQ 수정 성공");
        return "redirect:/admin/question/managerFaq";

    }

    @GetMapping("/create")
    public String goManagerFaqCreate() {

        return "admin/question/managerFaqCreate";
    }


    @PostMapping("/create")
    public String ManagerFaqCreate(AdminFaqDTO admincreatefaq, RedirectAttributes rttr) {

        adminFaqService.adminFaqCreate(admincreatefaq);
        System.out.println("check:" + admincreatefaq);


        return "redirect:/admin/question/managerFaq";
    }


    @GetMapping("/managerFaqDelete")
    public String goManagerFaqDelete(HttpServletRequest request) {


        int faqNum = Integer.parseInt(request.getParameter("faqNum"));

        adminFaqService.adminFaqDelete(faqNum);

        return "redirect:/admin/question/managerFaq";
    }



    @GetMapping("/question")
    public String goQuestion(Model model) {

        List<QuestionDTO> questionList = questionService.SelectAllquestion();
        System.out.println("question : " + questionList);
        model.addAttribute("questionList", questionList);
        return "/content/question/question";

    }

    @GetMapping("/userquestioncreate")
    public String questioncreate() {
        return "content/question/questioncreate";
    }


    @PostMapping("/questioncreate")
    public String Questioncreate(@ModelAttribute QuestionDTO questiondto, Model model, RedirectAttributes rttr) {  /*객체에다가 담아온다. 컬럼명 맞춰서 차곡차곡 담아서 가져온다*/

        questionService.questionCreate(questiondto);
        System.out.println("check:" + questiondto);

        return "redirect:/content/question/question";
    }

    @GetMapping("/adminquestion")
    public String adminQuestioncreate(Model model) {

        List<QuestionDTO> questionList = questionService.SelectAllquestion();
        model.addAttribute("questionList", questionList);
        return "admin/question/managerQuestion";
    }


    @GetMapping("/managerQuestionCreate/{questNum}/")
    public String managerQuestCreate(QuestionDTO adminquestion, RedirectAttributes rttr) {

        questionService.adminQuestionCreate(adminquestion);
        System.out.println("check:" + adminquestion);

        return "redirect:/admin/question/managerQuestion";


    }

    @GetMapping("/questionUpdate/{questNum}")
    public String goQuestionUpdate(Model model, @PathVariable("questNum") int qnumb) {
        System.out.println("qnumb : " + qnumb);

        QuestionDTO userQuestionList = questionService.userselectOneQuestion(qnumb);
        System.out.println("giveup:" + userQuestionList);

        model.addAttribute("userquestion", userQuestionList);
             return "/content/question/questionUpdate";

    }


    @PostMapping("questionRealUpdate/{questNum}")
    public String userquestionRealUpdate(QuestionDTO qdto, RedirectAttributes rttr) {
        questionService.userquestionup(qdto);
        System.out.println("what:" + qdto);
        rttr.addFlashAttribute("message", "Question 수정 성공");

        return "redirect:/content/question/question";
    }

    @GetMapping("/questionDelete")
    public String goUserQuestionDelete(HttpServletRequest request) {


        int questionNum = Integer.parseInt(request.getParameter("questionNum"));

        questionService.userQuestionDelete(questionNum);

        return "redirect:/content/question/question";

    }

}