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
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/record")
    @ResponseBody
    public ResponseEntity<String> recordPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            PayInfoDTO payment = new PayInfoDTO();
            payment.setPayMethod(paymentRequest.getPayMethod());
            payment.setPayPrice(paymentRequest.getAmount());
            payment.setPayNum(paymentRequest.getImpUid());

            paymentService.savePayment(payment);

            System.out.println("pay : " + payment);

            return new ResponseEntity<>("Payment recorded successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to record payment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}