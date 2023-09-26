package com.project.dasi.mypage.controller;


import com.project.dasi.auth.model.dao.UserRepository;
import com.project.dasi.mypage.model.dto.UserDTO;
import com.project.dasi.mypage.model.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.userdetails.UserDetails; // 스프링 시큐리티의 User 클래스

import java.security.Principal;

@Controller
@RequestMapping("/content/mypage")
public class MypageController {

    private MypageService mypageService;

    public String myPage(Model model, Principal principal) {
        // 현재 로그인한 사용자의 ID를 가져온다.
        String userId = principal.getName();

        //Service를 사용하여 사용자 정보를 가져온다.
        UserDTO userDTO = mypageService.getUserInfo(userId);
        if (userDTO == null) {
            return "/"; //사용자를 찾지 못한 경우 예외처리 페이지로 이동
        }
        //모델에 사용자 정보를 추가한다.
        model.addAttribute("user", userDTO);

        return "mypageMain";
    }


}

