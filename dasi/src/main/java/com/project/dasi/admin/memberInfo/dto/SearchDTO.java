package com.project.dasi.admin.memberInfo.dto;

import lombok.*;

public class SearchDTO implements java.io.Serializable {
    private String keyword;
    private String search;

    public SearchDTO() {
    }

    public SearchDTO(String keyword, String search) {
        this.keyword = keyword;
        this.search = search;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "keyword='" + keyword + '\'' +
                ", search='" + search + '\'' +
                '}';
    }
}
