package com.project.dasi.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @RequestMapping("/member/login/findId")
    public void goFindId() {
    }
    @RequestMapping("/member/login/findPw")
    public void goFindPw() {
    }
    @RequestMapping("/member/login/login")
    public void goLogin() {
    }    @RequestMapping("/member/login/loginSuccess")
    public void goLoginSuccess() {}

}

