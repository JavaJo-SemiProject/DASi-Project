package com.project.dasi.admin.memberInfo.controller;
import com.project.dasi.admin.memberInfo.dto.UserInfoDTO;
import com.project.dasi.admin.memberInfo.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/memberInfo")
public class AdminController {
    @GetMapping("/admin")
    public void goAdmin() {}
    @GetMapping("/userList")
    public void goUserList() {}
    private final UserInfoService userInfoService;

    public AdminController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public String selectUserList(Model model) {

        List<UserInfoDTO> userList = userInfoService.selectAllUserInfo();

        model.addAttribute("userList", userList);

        return "/memberInfo/userList";

    }

}
