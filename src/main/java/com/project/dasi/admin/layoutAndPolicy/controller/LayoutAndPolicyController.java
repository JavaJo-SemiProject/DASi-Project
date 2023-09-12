package com.project.dasi.admin.layoutAndPolicy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutAndPolicyController {
    @RequestMapping("/admin/layoutAndPolicy/adminLayout")
    public void goAdminLayout() {}
    @RequestMapping("/admin/layoutAndPolicy/adminLayoutEdit")
    public void goAdminLayoutEdit() {}

    @RequestMapping("/admin/layoutAndPolicy/adminPolicy")
    public void goAdminPolicy() {}

    @RequestMapping("/admin/layoutAndPolicy/adminPolicyEdit")
    public void goAdminPolicyEdit() {}


}
