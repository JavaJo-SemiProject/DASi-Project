package com.project.dasi.admin.question.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdminFaqDTO {

    private int faqNum;
    private String faqTitle;
    private String faqContent;

}
