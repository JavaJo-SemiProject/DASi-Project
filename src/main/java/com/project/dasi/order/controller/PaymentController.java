package com.project.dasi.order.controller;

import com.project.dasi.order.model.dto.PayInfoDTO;
import com.project.dasi.order.model.dto.PaymentRequest;
import com.project.dasi.order.model.service.PaymentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/content/mypage")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/paySuccess")
    public String paySuccess() {
        return "/content/mypage/paySuccess";
    }

    @PostMapping("/paySuccess")
    @ResponseBody
    public ResponseEntity<String> recordPayment(@RequestBody PaymentRequest paymentRequest) {

        JSONObject jsonObject = new JSONObject(paymentRequest);

        String payNum = jsonObject.getString("imp_uid");
        String orderId = jsonObject.getString("merchant_uid");
        int amount = jsonObject.getInt("amount");
        String payMethod = jsonObject.getString("payMethod");
        String buyerName = jsonObject.getString("buyer_name");


        System.out.println("payNum : " + payNum);
        System.out.println("price : " + amount);
        System.out.println("PayMethod : " + payMethod);
        System.out.println("BuyName : " + buyerName);
        try {
            PayInfoDTO payment = new PayInfoDTO();
            payment.setBuyer(buyerName);
            payment.setPayNum(payNum);
            payment.setPayMethod(payMethod);
            payment.setPayPrice(amount);
            payment.setOrderId(orderId);

            paymentService.savePayment(payment);

            System.out.println("pay : " + payment);

            return new ResponseEntity<>("Payment recorded successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to record payment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/payCancel")
    public String payCancel() {
        return "/content/mypage/payCancel";
    }
}