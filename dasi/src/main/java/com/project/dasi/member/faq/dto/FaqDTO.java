package com.project.dasi.member.faq.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FaqDTO implements java.io.Serializable {
    private int qCateCode;
    private int faqNum;
    private String faqTitle;
    private String faqContent;
}
