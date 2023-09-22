package com.project.dasi.admin.order.controller;

import com.project.dasi.admin.order.model.service.AdminOrderService;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin/order")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    public AdminOrderController(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }


    @GetMapping("/adminOrderList")
    public ModelAndView adminOrderList(ModelAndView model){
        List<OrderListDTO> orderList = adminOrderService.selectAllOrderList();
        model.addObject("orderList", orderList);
        model.setViewName("admin/order/adminOrderList");

        System.out.println("orderList : " + orderList);

        return model;
    }
    @GetMapping("/adminOrderDetail")
    public String adminOrderDetail(HttpServletRequest request, Model model){

        String orderId = request.getParameter("orderId");

        OrderListDTO orderDetail = adminOrderService.selectOrderDetail(orderId);

        model.addAttribute("order",orderDetail);


        return "/admin/order/adminOrderDetail";
    }

    @PostMapping("/adminOrderDetail")
    public Object adminOrderEdit(OrderListDTO orderList, RedirectAttributes rttr){


        adminOrderService.editStatus(orderList);

        System.out.println("Controller OrderList: " + orderList);

        return "redirect:/admin/order/adminOrderList";

    }
}
