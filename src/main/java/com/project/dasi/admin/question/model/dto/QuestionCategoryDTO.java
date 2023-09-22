package com.project.dasi.admin.question.model.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionCategoryDTO implements java.io.Serializable {
    private int qCateCode;  /*QCATE_CODE*/
    private String qCategory;   /*QCATEGORY*/
}