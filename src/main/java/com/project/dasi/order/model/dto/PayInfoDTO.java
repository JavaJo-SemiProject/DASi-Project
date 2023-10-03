package com.project.dasi.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PayInfoDTO {


   private String orderId;
   private String payNum;
   private String payDate;
   private int payPrice;
   private String payMethod;
   private String buyer;



}