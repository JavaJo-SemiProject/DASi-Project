package com.project.dasi.member.order.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderListDTO implements java.io.Serializable{
    private String orderId;
    private List<ProductDTO> productCode;
    private List<OrderStatusDTO> statusNum;
    private String payNum;
    private String cancelContent;
    private String sizeInfo;
    private String phrase;
    private String reqIssues;
    private String orderTime;
    private String orderDate;
    private int orderPrice;
    private List<OrderFileDTO> orderFiles;


}
