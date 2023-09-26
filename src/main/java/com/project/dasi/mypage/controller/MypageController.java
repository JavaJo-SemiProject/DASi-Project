package com.project.dasi.mypage.controller;

import com.project.dasi.admin.order.model.service.AdminOrderService;
import com.project.dasi.auth.model.dto.UserDTO;
import com.project.dasi.auth.model.service.UserService;
import com.project.dasi.mypage.model.service.MypageService;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/content/mypage")
public class MypageController {


    private final MypageService mypageService;// 사용자 정보 서비스
    private final AdminOrderService orderService;

    public MypageController(MypageService  mypageService, AdminOrderService orderService) {
        this.mypageService = mypageService;
        this.orderService = orderService;
    }

    @GetMapping("/mypageMain")
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

    @GetMapping("/myOrderList")
    public ModelAndView myOrderList(ModelAndView mv, Principal principal) {
        String userId = principal.getName();
        List<OrderListDTO> orderList = orderService.selectMyOrderList(userId);
        mv.addObject("orderList", orderList);
        mv.setViewName("/content/mypage/myOrderList");

        System.out.println("orderList : " + orderList);

        return mv;
    }

}

