package com.project.dasi.mypage.controller;

import com.project.dasi.mypage.model.service.MypageService;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/content/mypage")
public class MypageController {

   /* private final MypageService mypageService;

    public MypageController(MypageService mypageService) {
        this.mypageService = mypageService;
    }


    @GetMapping("/myOrderList")
    public String adminOrderList(Model model){
        List<OrderListDTO> orderList = mypageService.selectAllOrderList();
        model.addAttribute("orderList", orderList);
        return "/content/mypage/myOrderList";
    }
    @GetMapping("/myOrderDetail")
    public String adminOrderDetail(HttpServletRequest request, Model model){

        String orderId = request.getParameter("orderId");

        OrderListDTO orderDetail = mypageService.selectOrderDetail(orderId);

        model.addAttribute("order",orderDetail);

        return "/content/mypage/myOrderDetail";
    }*/

}
