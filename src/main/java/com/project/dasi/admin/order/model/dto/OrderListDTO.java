package com.project.dasi.admin.order.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderListDTO implements java.io.Serializable {
    private String orderId;
    private List<ProdctDTO> productCode;
    private List<OrderStatusDTO> statusNum;
    private String payNum;
    private String cancelContent;
    private String sizeInfo;
    private String phrase;
    private String reqIssues;
    private String orderDate;
    private String orderPrice;
    private List<PayInfoDTO> payCode;
}
