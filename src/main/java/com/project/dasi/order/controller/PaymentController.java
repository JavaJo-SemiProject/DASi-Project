package com.project.dasi.order.controller;

import com.project.dasi.order.model.dto.PayInfoDTO;
import com.project.dasi.order.model.dto.PaymentRequest;
import com.project.dasi.order.model.service.PaymentService;
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
        System.out.println("payNum : " + paymentRequest.getImp_uid());
        System.out.println("price : " + paymentRequest.getAmount());
        System.out.println("PayMethod : " + paymentRequest.getPayMethod());
        System.out.println("BuyName : " + paymentRequest.getBuyer_name());
        try {
            PayInfoDTO payment = new PayInfoDTO();
            payment.setBuyer(paymentRequest.getBuyer_name());
            payment.setPayNum(paymentRequest.getImp_uid());
            payment.setPayMethod(paymentRequest.getPayMethod());
            payment.setPayPrice(paymentRequest.getAmount());
            payment.setOrderId(paymentRequest.getMerchant_uid());

            paymentService.savePayment(payment);

            System.out.println("pay : " + payment);
            System.out.println("payNum : " + paymentRequest.getImp_uid());
            System.out.println("price : " + paymentRequest.getAmount());
            System.out.println("PayMethod : " + paymentRequest.getPayMethod());

            return new ResponseEntity<>("Payment recorded successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to record payment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}