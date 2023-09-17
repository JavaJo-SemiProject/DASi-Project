package com.project.dasi.admin.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @RequestMapping("/admin/order/adminOrderDetail")
    public void goAdminOrderDetail() {}
    @RequestMapping("/admin/order/adminOrderList")
    public void goAdminOrderList() {}
    @RequestMapping("/admin/order/orderRejectPage")
    public void goOrderRejectPage() {}
}
