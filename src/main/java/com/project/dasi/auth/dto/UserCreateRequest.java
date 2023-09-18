package com.project.dasi.auth.dto;

import com.project.dasi.auth.enumeration.Userrole;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
public class UserCreateRequest {


    private String usercode;
    private String userid;
    private String password;
    private String username;
    private String birthdate;
    private String email;
    private String tel;
    private String gender;
    private String joindate;
    private String withdrawstatus;
    private String withdrawdate;
    private Userrole userrole;



}
