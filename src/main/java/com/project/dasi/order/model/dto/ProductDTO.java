package com.project.dasi.member.order.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO implements java.io.Serializable{
    private String productCode;
    private String productName;
    private List<ProductCategoryDTO> categoryCode;
    private String productContent;
}
