package com.project.dasi.order.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private String userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private String birthDate;
    private String address;
    private String email;
    private String tel;
    private String gender;
    private String joinDate;

}
