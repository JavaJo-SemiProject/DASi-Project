package com.project.dasi.order.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentRequest {

    private String pg;
    private String payMethod;
    private String buyerEmail;
    private String buyer_name;
    private String buyerTel;
    private String buyerAddr;
    private String buyerPostcode;
    private int amount;
    private String imp_uid;
    private String merchant_uid;

}