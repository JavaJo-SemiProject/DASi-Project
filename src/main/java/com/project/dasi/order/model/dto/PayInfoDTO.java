package com.project.dasi.member.order.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PayInfoDTO implements java.io.Serializable{
    private String payNum;
    private String payDate;
    private String payTime;
    private String payPrice;
    private String payMethod;
}
