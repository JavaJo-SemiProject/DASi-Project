package com.project.dasi.admin.question.controller;


import com.project.dasi.admin.question.model.dto.AdminFaqDTO;
import com.project.dasi.admin.question.model.dto.QuestionDTO;
import com.project.dasi.admin.question.model.service.AdminFaqService;
import com.project.dasi.admin.question.model.service.QuestionService;
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
        List<AdminFaqDTO> faqList = adminFaqService.adminSelectAllFaqList();  /*AdminFaqDTO 들 여러개를 가져다가 보여줄거니까*/
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
        rttr.addFlashAttribute("message", "FaQ 수정 성공");
        return "redirect:/admin/question/managerFaq";

    }   /* @PathVariable("faqNum") int faqNum  을 쓰는 이유는 @PathVariable( )안의 변수명과 int *  으로 정한 * 이 이름이 다를 때 써준다. 같으면 안써도 됨. 알아서 찾아들어가*/
    /*  /managerFaqUpdate/{faqNum}  의 { } 안 변수명과 @PathVariable("faqNum")   안의 ( ) 안 변수명은 같아야한다*/

    @GetMapping("/create")
    public String goManagerFaqCreate() {

        return "admin/question/managerFaqCreate";
    }/*이 주소는 String이기 때문에 반환값이 String임*/


    /*@RequestMapping(value="/create", method={RequestMethod.POST})*/
    @PostMapping("/create")
    public String ManagerFaqCreate(AdminFaqDTO admincreatefaq, RedirectAttributes rttr) {

        adminFaqService.adminFaqCreate(admincreatefaq);
        System.out.println("check:" + admincreatefaq);


        return "redirect:/admin/question/managerFaq";
    }


    @GetMapping("/managerFaqDelete")   /*뒤에 ?를 달고 뭘 달고온다해도, 여기까지만 써주면 저절로 옴*/
    public String goManagerFaqDelete(HttpServletRequest request) {
        /* @RequestParam String title  로 해서 html단에서 title을 가져오면,
         * 이것은 즉 싣어오는 request에서 title을 빼서 쓰겠다는 것이다. 그대신 꼭!! 자료형을 맞춰줘야 하며,
         * 변수명은 db칼럼명과 동일하게 지정해줘야한다 */


        int faqNum = Integer.parseInt(request.getParameter("faqNum"));
        /*Long no = Long.valueOf(request.getParameter("no")); 으로 Long으로 바꿀거면 이렇게한다*/

        adminFaqService.adminFaqDelete(faqNum);

        return "redirect:/admin/question/managerFaq";
        /*return "admin/question/managerFaq";*/
    }


    /*마이페이지 안에서 이 회원에 대한 1:1글 남긴거 불러와야함. 이거 해결하기*/
    @GetMapping("/question/{userCode}")   /* 사용자 1:1문의 그저 조회 페이지 */
    public String goQuestion(Model model) {  /*모델을 들고 db에 가서 결과를 받아온다*/

        List<QuestionDTO> questionList = questionService.SelectAllquestion();  /*여러개 가져올거니까 리스트*/
        model.addAttribute("questionList", questionList);
        return "content/question/question";    /*여기서 리턴해주는 페이지는 보여줄 뷰 사이트의 uri를 기술. 뷰리졸버가 이 문구 앞뒤에 http이런거 붙여서 주소 완성시킨다.*/

    }

    @PostMapping("/questioncreate/{create}")  /* 사용자 1:1문의 작성 페이지!!->작성 후 조회페이지로 돌아감*/
    public String Questioncreate(@ModelAttribute QuestionDTO questiondto, RedirectAttributes rttr) {  /*객체에다가 담아온다. 컬럼명 맞춰서 차곡차곡 담아서 가져온다*/
        /*@ModelAttribute    이건 써도 되고 안써도 된다. 그냥 명시용임*/

        questionService.questionCreate(questiondto);
        System.out.println("check:" + questiondto);

        rttr.addFlashAttribute("message", "1:1문의 등록 성공");

        return "redirect:/content/question/question";
    }

    @GetMapping("/adminquestion")   /* 관리자 페이지에서 그저 1:1문의들 조회하는페이지->관리자1:1조회페이지로돌아감*/
    public String adminQuestioncreate(Model model) {

        List<QuestionDTO> questionList = questionService.SelectAllquestion();
        model.addAttribute("questionList", questionList);
        return "admin/question/managerQuestion";
    }


    @PostMapping("/managerQuestion/{questNum}/")   /* 관리자페이지에서 하나의 글에 대해 답변글 다는 페이지->관리자1:1조회페이지로 돌아감*/
    public String managerQuestCreate(QuestionDTO adminquestion, RedirectAttributes rttr) {

        questionService.adminQuestionCreate(adminquestion);
        System.out.println("check:" + adminquestion);   /*선생님이 이 단계 잘 되는지 확인 위해 콘솔 출력해보려고 쓴 코드*/


              return "redirect:/admin/question/managerQuestion";


    }

    @PostMapping("/questionUpdate/{questNum}")
    public String questionUpdate(QuestionDTO question, RedirectAttributes rttr) {

        questionService.questionUpdate(question);
        System.out.println("check:" + question);

        rttr.addFlashAttribute("message", "FaQ 수정 성공");
        return "redirect:/admin/question/managerQuestion";

    }


}
