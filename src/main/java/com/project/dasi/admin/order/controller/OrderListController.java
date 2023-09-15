package com.project.dasi.admin.order.controller;

import com.project.dasi.admin.order.model.dto.OrderListDTO;
import com.project.dasi.admin.order.model.service.OrderListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class OrderListController {

    private final OrderListService orderListService;

    public OrderListController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }


    @GetMapping("/adminOrderList")
    public String goAdminOrderList(Model model) {
        List<OrderListDTO> orderList = orderListService.selectAllOrderList();
        model.addAttribute("orderList", orderList);
        return "/admin/order/adminOrderList";
    }

    @GetMapping("/adminOrderDetail")
    public void goAdminOrderDetail() {}
    @GetMapping("/orderRejectPage")
    public void goOrderRejectPage() {}
}
