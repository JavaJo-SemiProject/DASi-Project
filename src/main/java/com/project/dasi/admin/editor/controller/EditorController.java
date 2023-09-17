package com.project.dasi.admin.editor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditorController {
    @RequestMapping("/admin/editor/adminLayout")
    public void goAdminLayout() {}
    @RequestMapping("/admin/editor/adminLayoutEdit")
    public void goAdminLayoutEdit() {}

    @RequestMapping("/admin/editor/adminPolicy")
    public void goAdminPolicy() {}

    @RequestMapping("/admin/editor/adminPolicyEdit")
    public void goAdminPolicyEdit() {}


}
