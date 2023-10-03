package com.project.dasi.question.model.dto;



import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FaqDTO implements java.io.Serializable {

    private Integer faqNum;
    private String faqTitle;
    private String faqContent;

  }

