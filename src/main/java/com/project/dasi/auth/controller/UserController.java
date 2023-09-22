package com.project.dasi.auth.controller;

import com.project.dasi.auth.dto.UserDTO;
import com.project.dasi.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/content/member")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    /**
     * 로그인 폼
     * @return
     */

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
    public String accessDenied() {
        return "content/member/fail";
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

}