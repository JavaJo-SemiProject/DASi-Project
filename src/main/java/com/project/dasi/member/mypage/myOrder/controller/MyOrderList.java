package com.project.dasi.member.mypage.myOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyOrderList {

        @RequestMapping("/member/mypage/myOrderList/myOrderList ")
        public void goMyOrder() {}
        @RequestMapping("/member/mypage/MyOrderDeatil")
        public void goMyOrderDeatil() {}

}
