package com.project.dasi.member.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @RequestMapping("/member/order/orderGuidePage")
    public void goOrderGuidePage() {}
    @RequestMapping("/member/order/orderRequestCheck")
    public void goOrderRequestCheck() {}
    @RequestMapping("/member/order/orderRequestPage")
    public void goOrderRequestPage() {}
    @RequestMapping("/member/order/orderSuccessPage")
    public void goOrderSuccessPage() {}

}

