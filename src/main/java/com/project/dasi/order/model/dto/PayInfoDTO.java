package com.project.dasi.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PayInfoDTO {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private String payNum;
   private String payDate;
   private int payPrice;
   private String payMethod;

}
