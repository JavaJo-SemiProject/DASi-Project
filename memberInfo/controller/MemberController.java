package com.project.dasi.admin.memberInfo.controller;

import com.project.dasi.admin.memberInfo.dto.MemberDTO;
import com.project.dasi.admin.memberInfo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/searchMemberList")
    public String getMemberListByCondition(Model model) {

        List<MemberDTO> memberList = memberService.getMemberList();
        memberList.forEach(System.out::println);

        return "admin/memberInfo/memberList";

    }


    @GetMapping("memberRegist")
    public void registPage() {

    }
    @PostMapping("memberRegist")
    public String registMember(MemberDTO newMember, RedirectAttributes rttr) {

        memberService.registMember(newMember);
        rttr.addFlashAttribute("successMessage", "회원 등록 성공");

        return "redirect:/admin/memberInfo/memberList";
    }


}
