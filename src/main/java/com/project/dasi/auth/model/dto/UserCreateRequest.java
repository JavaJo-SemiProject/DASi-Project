package com.project.dasi.auth.model.dto;

import com.project.dasi.auth.model.enumeration.Userrole;
import lombok.Getter;
import lombok.Setter;

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
