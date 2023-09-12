package com.project.dasi.admin.memberInfo.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserAuthDTO implements java.io.Serializable {
    private String authCode;
    private String userCode;
}
