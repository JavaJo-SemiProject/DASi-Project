package com.project.dasi.admin.orderList.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderListDTO implements java.io.Serializable {
    private String orderId;
    private String productCode;
    private String statusNum;
    private String payNum;
    private String cancelContent;
    private String chest;
    private String neck;
    private String back;
    private String head;
    private String phrase;
    private String reqIssues;
    private String orderTime;
    private String orderDate;
    private String orderPrice;
}
