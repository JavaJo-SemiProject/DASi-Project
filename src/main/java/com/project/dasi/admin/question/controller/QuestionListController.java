package com.project.dasi.admin.question.controller;


import com.project.dasi.admin.question.model.dto.AdminFaqDTO;
import com.project.dasi.admin.question.model.service.AdminFaqService;
import com.project.dasi.question.model.dto.FaqDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/question")
public class QuestionListController {

    private final AdminFaqService adminFaqService;

    public QuestionListController(AdminFaqService adminFaqService) {
        this.adminFaqService = adminFaqService;
    }


    @GetMapping("/managerFaq")
    public String goManagerFaq(Model model) {
        List<AdminFaqDTO> faqList = adminFaqService.adminSelectAllFaqList();
        model.addAttribute("faqList", faqList);
        return "admin/question/managerFaq";
    }

    @GetMapping("/managerFaqUpdate/{Num}")     /*{ }안 이름은 내 맘대로 지으면 되고,/managerFaqUpdate/ 뒤에 있다는 이 주소만을 통해서 알아듣는다.
    {Num}랑 @PathVariable("Num")가 짝,int no랑 adminSelectOneFaqList(no)가 짝이다. adminSelectOneFaqList(no)를 받을 곳에서의 ( ) 안은 자료형만 같다면 변수명 달라도 됨*/

    public String goManagerFaqUpdate(Model model, @PathVariable("Num") int no) {

        AdminFaqDTO faqList = adminFaqService.adminSelectOneFaqList(no);
        model.addAttribute("faqList", faqList);
        return "admin/question/managerFaqUpdate";
    }

    @PostMapping("/managerFaqUpdate/{faqNum}")
    public String managerFaqUpdateRegist(/*@ModelAttribute */ AdminFaqDTO adminfaq, /*@PathVariable("faqNum") int faqNum,*/ RedirectAttributes rttr /*, int faqNo*/) {

        adminFaqService.adminFaqUpdateRegist(adminfaq);
        System.out.println("check:" + adminfaq);   /*선생님이 이 단계 잘 되는지 확인 위해 콘솔 출력해보려고 쓴 코드*/


        /*rttr.addAttribute("message", "수정완료");*/  /*이걸 하면 uri끝에 message=수정완료 이게 뜨고, 들고가는 값들이 모두 서버의 콘솔에 뜬다  */

        return "redirect:/admin/question/managerFaq";

       }   /* @PathVariable("faqNum") int faqNum  을 쓰는 이유는 @PathVariable( )안의 변수명과 int *  으로 정한 * 이 이름이 다를 때 써준다. 같으면 안써도 됨. 알아서 찾아들어가*/
   /*  /managerFaqUpdate/{faqNum}  의 { } 안 변수명과 @PathVariable("faqNum")   안의 ( ) 안 변수명은 같아야한다*/

    @GetMapping ("/create")
    public String goManagerFaqCreate() {

        return "admin/question/managerFaqCreate";  }/*이 주소는 String이기 때문에 반환값이 String임*/


    /*@RequestMapping(value="/create", method={RequestMethod.POST})*/
    @PostMapping ("/create")
    public String ManagerFaqCreate(AdminFaqDTO admincreatefaq, RedirectAttributes rttr) {

        adminFaqService.adminFaqCreate(admincreatefaq);
        System.out.println("check:" + admincreatefaq);


        return "redirect:/admin/question/managerFaq";
    }



    @GetMapping("/managerFaqDelete")   /*뒤에 ?를 달고 뭘 달고온다해도, 여기까지만 써주면 저절로 옴*/
        public String goManagerFaqDelete(HttpServletRequest request) {

        int faqNum = Integer.parseInt(request.getParameter("faqNum"));
        /*Long no = Long.valueOf(request.getParameter("no")); 으로 Long으로 바꿀거면 이렇게한다*/

        adminFaqService.adminFaqDelete(faqNum);

        return "redirect:/admin/question/managerFaq";
        /*return "admin/question/managerFaq";*/
    }













}


   /* @GetMapping("/managerFaqUpdate")
    public String goManagerFaqUpdate(HttpServletRequest request, Model model) {

        Integer num = Integer.valueOf(request.getParameter("num"));
        AdminFaqDTO faqList = adminFaqService.adminSelectOneFaqList(num);
        model.addAttribute("faqList", faqList);
        return "admin/question/managerFaqUpdate";
    }*/


    /*@RequestMapping("/admin/question/managerQuestion")
    public void goManagerQuestion() {}
    @RequestMapping("/admin/question/managerQuestionCreate")
    public void goManagerQuestionCreate() {}*/



