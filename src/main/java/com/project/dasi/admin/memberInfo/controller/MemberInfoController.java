package com.project.dasi.admin.memberInfo.controller;

import com.github.pagehelper.PageInfo;
import com.project.dasi.admin.memberInfo.model.dto.SearchDTO;
import com.project.dasi.admin.memberInfo.model.service.MemberService;

import com.project.dasi.auth.model.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/memberInfo")
public class MemberInfoController {

    private final MemberService memberService;

    public MemberInfoController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/memberList")
    public String getMemberList(Model model) {

        List<UserDTO> memberList = memberService.getMemberList();

        model.addAttribute("title", "모든 회원 목록 조회");
        model.addAttribute("memberList", memberList);

        return "admin/memberInfo/memberList";
    }

    @GetMapping("/memberRegist")
    public void goMemberRegist() {
    }
    @PostMapping("memberRegist")
    public String registMember(UserDTO newMember, RedirectAttributes rttr) {

        memberService.registMember(newMember);
        rttr.addFlashAttribute("successMessage", "회원 등록 성공");

        return "redirect:/admin/memberInfo/memberList";
    }


    @GetMapping("/memberSearch")
    public String searchMember(@ModelAttribute SearchDTO search,
                               @RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
        PageInfo<UserDTO> p = new PageInfo<>(memberService.searchMember(pageNum, search), 10);
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

        memberService.modifyMember(member);

        return "redirect:/admin/memberInfo/memberList";
    }

    @GetMapping("/memberDelete")
    public void goMemberDelete() {
    }
    @PostMapping("memberDelete")
    public String deleteMember(Map<String, String> parameter) {

        memberService.deleteMember(parameter);

        return "redirect:/admin/memberInfo/memberList";
    }

}