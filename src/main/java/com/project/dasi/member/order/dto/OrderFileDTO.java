package com.project.dasi.member.order.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderFileDTO implements java.io.Serializable{

    private String fileCode;
    private String uploadPath;
    private String originName;
    private String transferName;
    private String ext;
    private String orderId;

}
