package com.project.dasi.question.model.dto;



import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FaqDTO implements java.io.Serializable {

    /*private FaqCategoryDTO faqCategoryDTO;*/  /*여기에서 불러올 객체만 생성해줘라.
    그 다음에 구현할 뷰단에서 이 객체 안 객체 안 무엇! 이렇게 지정해서 꺼내오면 된다*/
    private Integer faqNum;
    private String faqTitle;
    private String faqContent;

    public Integer getFaqNum() {
        return faqNum;
    }

    public void setFaqNum(Integer faqNum) {
        this.faqNum = faqNum;
    }

    public String getFaqTitle() {
        return faqTitle;
    }

    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public String getFaqContent() {
        return faqContent;
    }

    public void setFaqContent(String faqContent) {
        this.faqContent = faqContent;
    }



    @Override
    public String toString() {
        return "FaqDTO{" +
                "faqNum=" + faqNum +
                ", faqTitle='" + faqTitle + '\'' +
                ", faqContent='" + faqContent + '\'' +
                '}';
    }
}

