package com.project.dasi.auth.controller;

import com.github.pagehelper.PageInfo;
import com.project.dasi.admin.memberInfo.model.dto.SearchDTO;
import com.project.dasi.auth.model.dto.UserDTO;
import com.project.dasi.auth.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/content/member")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    private UserDTO userDTO;

    @GetMapping("/login")
    public String login(){
        return "content/member/login";
    }

    @PostMapping("login")
    public String loginPost(){
        return "content/member/login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "content/member/signup";
    }

    @GetMapping("/fail")
    public ModelAndView goFail(@RequestParam String errorMessage, ModelAndView mv) {
        mv.addObject("message", errorMessage);
        mv.setViewName("content/member/fail");

        return mv;
    }

    @GetMapping("/findId")
    public String goFindId() {
        return "content/member/findId";
    }

    @GetMapping("/findPw")
    public String goFindPw() {
        return "content/member/findPw";
    }

    @PostMapping("signup")
    public String signUp(UserDTO member) {
        userService.registMember(member);
        return "redirect:/";
    }

    @GetMapping("/success")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        UserDTO userDTO = (UserDTO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("info", userDTO.getUserId() +"님");      //유저 아이디
        return "/content/member/success";
    }

    //아이디 중복체크
    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("userId") String userId) {
        int cnt = userService.idCheck(userId);
        return cnt;

    }

    @PostMapping("/emailCheck")
    @ResponseBody
    public int emailCheck(@RequestParam("email") String email) {
        int cnt = userService.emailCheck(email);
        return cnt;

    }

    @PostMapping("/idAndEmailCheck")
    @ResponseBody
    public Integer idAndEmailCheck(
                               @RequestParam(required = true, value = "userId") String userId,
                               @RequestParam(required = true, value = "email") String email) {
        Integer cnt = userService.idAndEmailCheck(userId, email);
        return cnt;

    }


    @PostMapping("/findIdResult")
    public String searchMember(@ModelAttribute SearchDTO search,
                               @RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
        PageInfo<UserDTO> p = new PageInfo<>(userService.searchMember(pageNum, search), 10);
        model.addAttribute("users", p);
        System.out.println(search);
        model.addAttribute("search", search);
        return "content/member/findIdResult";
    }

    @PostMapping("findPw")
    public String modifyPassword(UserDTO member) {
        userService.modifyPassword(member);

        return "redirect:/content/member/login";
    }



}