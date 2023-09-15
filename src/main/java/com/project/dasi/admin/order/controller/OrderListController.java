package com.project.dasi.admin.orderList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/orderList")
public class OrderListController {
    @GetMapping("/adminOrderDetail")
    public void goAdminOrderDetail() {}
    @GetMapping("/adminOrderList")
    public void goAdminOrderList() {}
    @GetMapping("/orderRejectPage")
    public void goOrderRejectPage() {}
}
