package com.project.dasi.auth.dto;

import com.project.dasi.auth.enumeration.Userrole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String userid;
    private String password;
    private String email;
    private Userrole userrole;

    @Builder
    private UserDTO(String userid, String password, String email, Userrole userrole) {
        this.userid = userid;
        this.password = password;
        this.email = email;
        this.userrole = userrole;
    }

}
