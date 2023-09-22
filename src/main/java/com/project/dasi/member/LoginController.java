package com.project.dasi.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/content/member")
@Controller
public class LoginController {


    @GetMapping("findId")
    public void goFindId() {
    }
    @RequestMapping("/findPw")
    public void goFindPw() {
    }
    @RequestMapping("/login")
    public void goLogin() {
    }
    @RequestMapping("/signup")
    public void goSignup() {}
    @RequestMapping("/fail")
    public void goLoginFail() {}
    @RequestMapping("/success")
    public void goLoginSuccess() {}
}

