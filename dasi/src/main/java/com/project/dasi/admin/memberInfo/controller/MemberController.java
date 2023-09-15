package com.project.dasi.admin.memberInfo.controller;

import com.github.pagehelper.PageInfo;
import com.project.dasi.admin.memberInfo.dto.MemberDTO;
import com.project.dasi.admin.memberInfo.dto.SearchDTO;
import com.project.dasi.admin.memberInfo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/memberInfo")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/memberList")
    public String getMemberList(Model model) {

        List<MemberDTO> memberList = memberService.getMemberList();

        model.addAttribute("title", "모든 회원 목록 조회");
        model.addAttribute("memberList", memberList);

        return "admin/memberInfo/memberList";
    }

    @GetMapping("/memberRegist")
    public void registPage() {

    }
    @PostMapping("memberRegist")
    public String registMember(MemberDTO newMember, RedirectAttributes rttr) {

        memberService.registMember(newMember);
        rttr.addFlashAttribute("successMessage", "회원 등록 성공");

        return "redirect:/admin/memberInfo/memberList";
    }

    @GetMapping("/page")
    public String page(@ModelAttribute SearchDTO search,
                       @RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
        PageInfo<MemberDTO> p = new PageInfo<>(memberService.getUserList(pageNum, search), 10);
        model.addAttribute("users", p);
        System.out.println(search);
        model.addAttribute("search", search);
        return "admin/memberInfo/page";
    }

}
