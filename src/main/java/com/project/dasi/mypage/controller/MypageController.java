package com.project.dasi.mypage.controller;

import com.project.dasi.auth.model.service.UserService;
import com.project.dasi.mypage.model.service.MypageService;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.userdetails.UserDetails; // 스프링 시큐리티의 User 클래스


import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/content/mypage")
public class MypageController {

    @Autowired
    private UserService usersService;// 사용자 정보 서비스

    @GetMapping("/mypageMain")
    public String myPage(Model model, Principal principal) {
        String userId = principal.getName();
        User user = usersService.findByUsername(userId);

        model.addAttribute("user", user);

        return "mypage";
    }
}

