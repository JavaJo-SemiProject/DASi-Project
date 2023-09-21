package com.project.dasi.member.join.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.dasi.member.join.dto.MemberDTO;
import com.project.dasi.common.exception.member.MemberRegistException;
import com.project.dasi.member.join.service.MemberServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/join")
public class JoinController {

    private final PasswordEncoder passwordEncoder;

    private final MemberServiceImpl memberService;

    public JoinController(PasswordEncoder passwordEncoder, MemberServiceImpl memberService) {
        this.passwordEncoder = passwordEncoder;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String goJoinMemberShip() {
        return "member/login/login";
    }

    @PostMapping("/joinMembership")
    public String registMember(@ModelAttribute MemberDTO member, HttpServletRequest request, RedirectAttributes rttr) throws MemberRegistException {

        String address = request.getParameter("entedAddrForm") + "$" + request.getParameter("entedAddr") + "$" + request.getParameter("entedRestAddr");
        member.setAddr(address);
        member.setUserPwd(passwordEncoder.encode(member.getUserPwd()));

        memberService.registMember(member);

        rttr.addFlashAttribute("message", "회원가입이 되었습니다.");

        return "redirect:/";

    }

    @PostMapping
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO memberDTO) throws JsonProcessingException {


        String result = "사용 가능한 아이디 입니다.";


/*        if("".equals(memberDTO.getUserId())) {

            result = "아이디를 입력해주세요.";
        } else if (memberService.selectUserId(memberDTO.getUserId())) {
            result = "중복된 아이디가 존재합니다.";
        }*/

        return ResponseEntity.ok(result);
    }


    @GetMapping("/login")
    public String goJoinMembership() {

        return "member/join/JoinMemberShip";
    }


}

