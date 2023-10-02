package com.project.dasi.admin.order.controller;

import com.project.dasi.admin.order.model.service.AdminOrderService;
import com.project.dasi.mypage.model.service.MypageService;
import com.project.dasi.order.model.dto.OrderListDTO;
import com.project.dasi.order.model.dto.PayInfoDTO;
import com.project.dasi.order.model.dto.PaymentRequest;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("admin/order")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    public AdminOrderController(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }


    @GetMapping("/adminOrderList")
    public ModelAndView adminOrderList(ModelAndView model) {
        List<OrderListDTO> orderList = adminOrderService.selectAllOrderList();
        model.addObject("orderList", orderList);
        model.setViewName("admin/order/adminOrderList");

        System.out.println("orderList : " + orderList);

        return model;
    }

    @GetMapping("/adminOrderDetail")
    public String adminOrderDetail(HttpServletRequest request, Model model) {

        String orderId = request.getParameter("orderId");

        OrderListDTO orderDetail = adminOrderService.selectOrderDetail(orderId);

        model.addAttribute("order", orderDetail);

        System.out.println("model" + model);

        return "/admin/order/adminOrderDetail";
    }

    @PostMapping("/adminOrderDetail")
    public Object adminOrderEdit(OrderListDTO orderList, RedirectAttributes rttr) {

        orderList.setOrderPrice(Integer.parseInt(String.valueOf(orderList.getOrderPrice())));

        adminOrderService.editStatus(orderList);


        System.out.println("Controller OrderList: " + orderList);

        return "redirect:/admin/order/adminOrderList";

    }

    @PostMapping("/invoiceSucess")
    @ResponseBody
    public ResponseEntity<String> recordInvoice(@RequestBody OrderListDTO order) {

        JSONObject jsonObject = new JSONObject(order);

            String invoice = jsonObject.getString("invoice");
            String orderId = String.valueOf(jsonObject.getInt("orderId"));
            System.out.println("invoice : " + invoice);
            System.out.println("orderId : " + orderId);

            try {
                OrderListDTO orderList = new OrderListDTO();
                orderList.setInvoice(invoice);
                orderList.setOrderId(Integer.parseInt(orderId));

                adminOrderService.updateDeliver(order);

                System.out.println("order con : " + orderList);

                return new ResponseEntity<>("송장번호 저장 성공", HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("송장번호 저장 실패", HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    @PostMapping("/deliverEnd")
    @ResponseBody
    public ResponseEntity<String> recordPayment(@RequestBody OrderListDTO order) {

        JSONObject jsonObject = new JSONObject(order);

            String deliverEnd = jsonObject.getString("deliverEnd");
            int orderId = jsonObject.getInt("orderId");
            System.out.println("deliverEnd : " + deliverEnd);
            System.out.println("orderId : " + orderId);

            try {
                OrderListDTO orderList = new OrderListDTO();
                orderList.setDeliverEnd(deliverEnd);
                orderList.setOrderId(orderId);

                adminOrderService.updateDeliver(order);

                System.out.println("order con : " + orderList);

                return new ResponseEntity<>("배송 완료 일자 저장 성공", HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("배송 완료 일자 저장 실패", HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }
}
