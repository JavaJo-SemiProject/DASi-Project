package com.ohgiraffers.thymeleafspringboot.common.exception.member;

public class LoginFailedException extends Exception {

    public LoginFailedException(String msg){
        super(msg);
    }

}