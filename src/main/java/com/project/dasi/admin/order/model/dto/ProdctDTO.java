package com.project.dasi.admin.order.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProdctDTO {

    private String productCode;
    private String productName;
    private List<ProdctCategoryDTO> categoryCode;
    private String productContent;

}
