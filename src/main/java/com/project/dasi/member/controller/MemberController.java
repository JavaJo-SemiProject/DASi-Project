package com.project.dasi.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    @RequestMapping("/content/member/login")
    public void goAdminLayout() {}
    @RequestMapping("/content/member/joinMembership")
    public void goAdminLayoutEdit() {}

    @RequestMapping("/content/member/findId")
    public void goAdminPolicy() {}

    @RequestMapping("/content/member/findPw")
    public void goAdminPolicyEdit() {}


}
