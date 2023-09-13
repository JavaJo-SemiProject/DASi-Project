package com.project.dasi.admin.memberInfo.dto;
import lombok.*;
@Getter
@Setter
@ToString
public class SearchCriteria {
    private int pageNum;
    private int pageAmount;
    private String searchType;
    private String searchKeyword;

    public SearchCriteria() {
        this(1, 10);
    }
    public SearchCriteria(int pageNum, int pageAmount) {
        this.pageNum = pageNum;
        this.pageAmount = pageAmount;
    }

    public String[] getSearchTypeArray() {
        return searchType == null ? new String[]{} : searchType.split("");
    }

}
