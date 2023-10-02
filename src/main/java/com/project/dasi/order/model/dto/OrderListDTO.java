package com.project.dasi.order.model.dto;


import com.project.dasi.auth.model.dto.UserDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderListDTO implements java.io.Serializable{

    private int orderId;
    private UserDTO userCode;
    private String user;
    private StatusDTO statusNum;
    private String status;
    private String cancelContent;
    private String sizeInfo;
    private String phrase;
    private String reqIssues;
    private String orderDate;
    private int orderPrice;
    /*private List<OrderFileDTO> orderFileList;*/
    private PCategoryDTO productCategory;
    private String categoryCode;
    private String receiver;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String recePhone;
    private String invoice;
    private PayInfoDTO payInfo;
    private String payNum;


}
