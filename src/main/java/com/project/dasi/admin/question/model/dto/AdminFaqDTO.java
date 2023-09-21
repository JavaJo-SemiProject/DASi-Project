package com.project.dasi.admin.question.model.dto;

import lombok.*;


public class AdminFaqDTO {

    private int faqNum;
    private String faqTitle;
    private String faqContent;

  public AdminFaqDTO() {
    }

    public AdminFaqDTO(int faqNum, String faqTitle, String faqContent) {
        this.faqNum = faqNum;
        this.faqTitle = faqTitle;
        this.faqContent = faqContent;
    }

    public int getFaqNum() {
        return faqNum;
    }

    public void setFaqNum(int faqNum) {
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
        return "AdminFaqDTO{" +
                "faqNum=" + faqNum +
                ", faqTitle='" + faqTitle + '\'' +
                ", faqContent='" + faqContent + '\'' +
                '}';
    }
}
