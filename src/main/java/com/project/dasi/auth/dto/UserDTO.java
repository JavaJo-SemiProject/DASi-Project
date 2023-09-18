package com.project.dasi.auth.dto;

import com.project.dasi.auth.enumeration.Userrole;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
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
    @Builder
    public UserDTO(String usercode, String userid, String password, String username, String birthdate, String email, String tel, String gender, String joindate, String withdrawstatus, String withdrawdate, Userrole userrole) {
        this.usercode = usercode;
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.birthdate = birthdate;
        this.email = email;
        this.tel = tel;
        this.gender = gender;
        this.joindate = joindate;
        this.withdrawstatus = withdrawstatus;
        this.withdrawdate = withdrawdate;
        this.userrole = userrole;
    }
}
