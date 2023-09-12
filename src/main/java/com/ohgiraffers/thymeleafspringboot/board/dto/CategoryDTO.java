package com.ohgiraffers.thymeleafspringboot.board.dto;

public class CategoryDTO {
    private Long code;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
