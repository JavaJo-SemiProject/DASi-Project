package com.project.dasi.order.controller;

import com.project.dasi.order.model.dto.OrderListDTO;
import com.project.dasi.order.model.service.OrderRequestServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/content/order")
public class OrderRequestController {

    private final OrderRequestServiceImpl orderRequestServiceImpl;


    public OrderRequestController(OrderRequestServiceImpl orderRequestServiceImpl) {
        this.orderRequestServiceImpl = orderRequestServiceImpl;
    }

    @GetMapping("/orderGuidePage")
    public String goOrderGuidePage(){
        return "/content/order/orderGuidePage";
    }


    @GetMapping("/orderRequestPage")
    public String goOrderRequestPage(){
        return "/content/order/orderRequestPage";
    }

    @PostMapping("/orderRequestPage")
    public String orderRegist(@ModelAttribute OrderListDTO order, RedirectAttributes rttr){

        System.out.println("order con : " + order);

        orderRequestServiceImpl.registOrder(order);


        rttr.addFlashAttribute("message","주문 요청이 성공하셨습니다.");

        return "redirect:/content/mypage/myOrderList";
    }

}
