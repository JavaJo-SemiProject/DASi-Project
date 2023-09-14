package com.project.dasi.member.faq.dto;

public class FaqDTO extends FaqCategoryDTO {  /*FaqCategoryDTO를 상속받아서 FaqCategoryDTO의 것들을
상속받아서 쓴다.FaqCategoryDTO랑 연결되는거라서 FaqCategoryDTO를 갖다쓸거니까 이렇게해야함*/
    private Integer faqNum;
    private String faqTitle;
    private String faqContent;

    public FaqDTO() {
    }

    public FaqDTO(Integer faqNum, String faqTitle, String faqContent) {
        this.faqNum = faqNum;
        this.faqTitle = faqTitle;
        this.faqContent = faqContent;
    }

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

 
