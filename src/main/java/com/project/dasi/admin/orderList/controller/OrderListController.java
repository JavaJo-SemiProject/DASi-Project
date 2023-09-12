package com.project.dasi.admin.orderList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderListController {
    @RequestMapping("/admin/orderList/adminOrderDetail")
    public void goAdminOrderDetail() {}
    @RequestMapping("/admin/orderList/adminOrderList")
    public void goAdminOrderList() {}
    @RequestMapping("/admin/order/orderRejectPage")
    public void goOrderRejectPage() {}
}
