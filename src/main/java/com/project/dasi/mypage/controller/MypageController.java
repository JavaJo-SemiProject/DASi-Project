package com.project.dasi.mypage.controller;


import com.project.dasi.auth.model.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.userdetails.UserDetails; // 스프링 시큐리티의 User 클래스

import java.security.Principal;

@Controller
@RequestMapping("/content/mypage")
public class MypageController {

    @Autowired
    private UserRepository userRepository;

    public String myPage(Model model, Principal principal) {
        String 
    }


}

