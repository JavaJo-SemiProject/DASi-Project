package com.project.dasi.admin.memberInfo.controller;

import com.github.pagehelper.PageInfo;
import com.project.dasi.admin.memberInfo.model.dto.SearchDTO;
import com.project.dasi.auth.dto.UserDTO;
import com.project.dasi.auth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/admin/memberInfo")
public class MemberInfoController {
    @GetMapping("/admin")
    public void goAdmin() {}
    private final UserService userService;

    public MemberInfoController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/memberRegist")
    public void goMemberRegist() {
    }
    @PostMapping("memberRegist")
    public String registMember(UserDTO newMember, RedirectAttributes rttr) {

        userService.registMember(newMember);
        rttr.addFlashAttribute("successMessage", "회원 등록 성공");

        return "redirect:/content/member/login";
    }


    @GetMapping("/memberSearch")
    public String searchMember(@ModelAttribute SearchDTO search,
                               @RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
        PageInfo<UserDTO> p = new PageInfo<>(userService.searchMember(pageNum, search), 10);
        model.addAttribute("users", p);
        System.out.println(search);
        model.addAttribute("search", search);
        return "admin/memberInfo/memberSearch";
    }
    @GetMapping("/memberModify")
    public void goMemberModify() {
    }
    @PostMapping("memberModify")
    public String modifyMember(UserDTO member) {

        userService.modifyMember(member);

        return "redirect:/admin/memberInfo/memberList";
    }

    @GetMapping("/memberDelete")
    public void goMemberDelete() {
    }
    @PostMapping("memberDelete")
    public String deleteMember(Map<String, String> parameter) {

        userService.deleteMember(parameter);

        return "redirect:/admin/memberInfo/memberList";
    }

}
