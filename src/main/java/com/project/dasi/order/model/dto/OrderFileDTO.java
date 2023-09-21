package com.project.dasi.order.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderFileDTO implements java.io.Serializable{

    private OrderListDTO orderId;
    private String fileCode;
    private String originName;
    private String savedName;
    private String uploadPath;
    private String savePath;

}
