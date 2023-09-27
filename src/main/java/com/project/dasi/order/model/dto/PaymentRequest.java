package com.project.dasi.order.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    private String pg;
    private String payMethod;
    private String buyerEmail;
    private String buyerName;
    private String buyerTel;
    private String buyerAddr;
    private String buyerPostcode;
    private int amount;
    private String impUid;
    private String merchantUid;

}
