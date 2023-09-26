package com.project.dasi.mypage.controller;

import com.project.dasi.admin.order.model.service.AdminOrderService;
import com.project.dasi.auth.model.dto.UserDTO;
import com.project.dasi.auth.model.service.UserService;
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


    private final UserService usersService;// 사용자 정보 서비스
    private final AdminOrderService orderService;

    public MypageController(UserService usersService, AdminOrderService orderService) {
        this.usersService = usersService;
        this.orderService = orderService;
    }

    @GetMapping("/mypageMain")
    public String myPage(Model model, Principal principal) {
        String userId = principal.getName();
        User user = usersService.findByUsername(userId);

        model.addAttribute("user", user);

        return "mypage";
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

