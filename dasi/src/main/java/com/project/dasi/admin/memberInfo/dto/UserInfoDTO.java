package com.project.dasi.admin.memberInfo.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserInfoDTO implements java.io.Serializable {
    private String userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private String birthDate;
    private String email;
    private String tel;
    private String gender;
    private String marketingStatus;
    private String joinDate;
    private String withdrawStatus;
    private String withdrawDate;
}
