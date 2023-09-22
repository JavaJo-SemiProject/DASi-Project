package com.project.dasi.order.model.dto;


import com.project.dasi.admin.memberInfo.model.dto.MemberDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderListDTO implements java.io.Serializable{
    private String orderId;
    private MemberDTO userId;
    private StatusDTO statusNum;
    private String payNum;
    private String cancelContent;
    private String sizeInfo;
    private String phrase;
    private String reqIssues;
    private String orderDate;
    private int orderPrice;
    private List<OrderFileDTO> orderFileList;
    private PCategoryDTO productCategory;
}
