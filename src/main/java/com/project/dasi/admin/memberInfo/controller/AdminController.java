package com.project.dasi.admin.memberInfo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/memberInfo")
public class AdminController {
    @GetMapping("/admin")
    public void goAdmin() {}

    /*@GetMapping("/memberList")
    public void goMemberList() {}

    @GetMapping("/memberRegist")
    public void goMemberRegist() {}*/

}
