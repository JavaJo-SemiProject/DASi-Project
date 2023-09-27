package com.project.dasi.order.model.service;

import com.project.dasi.order.model.dao.PaymentMapper;
import com.project.dasi.order.model.dto.PayInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentService(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    public void savePayment(PayInfoDTO payment) {
        paymentMapper.insertPayment(payment);
    }
}
