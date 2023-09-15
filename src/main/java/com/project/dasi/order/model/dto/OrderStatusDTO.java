package com.project.dasi.member.order.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderStatusDTO implements java.io.Serializable{
    private String statusNum;
    private String status;
}
