package com.project.dasi.member.order.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderFileDTO implements java.io.Serializable{

    private List<OrderListDTO> orderId;
    private String fileCode;
    private String uploadPath;
    private String originName;
    private String transferName;
    private String ext;

}
