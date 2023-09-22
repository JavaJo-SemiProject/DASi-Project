package com.project.dasi.auth.dto;

import com.project.dasi.auth.enumeration.Userrole;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    @NotNull
    private String userid;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private Userrole userrole;

}
