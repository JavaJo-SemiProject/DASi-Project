package com.project.dasi.member.faq.dto;

public class FaqCategoryDTO {
    private Integer qcateCode;
    private String qcategory;

    public FaqCategoryDTO() {
    }

    public FaqCategoryDTO(Integer qcateCode, String qcategory) {
        this.qcateCode = qcateCode;
        this.qcategory = qcategory;
    }

    public Integer getQcateCode() {
        return qcateCode;
    }

    public void setQcateCode(Integer qcateCode) {
        this.qcateCode = qcateCode;
    }

    public String getQcategory() {
        return qcategory;
    }

    public void setQcategory(String qcategory) {
        this.qcategory = qcategory;
    }

    @Override
    public String toString() {
        return "QuestionCategoryDTO{" +
                "qcateCode=" + qcateCode +
                ", qcategory='" + qcategory + '\'' +
                '}';
    }
}
