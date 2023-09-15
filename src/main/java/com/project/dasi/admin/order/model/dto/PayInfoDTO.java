package com.project.dasi.admin.order.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PayInfoDTO {

    private String payCode;
    private String payDate;
    private String payTime;
    private String payMethod;

}
