package com.project.dasi.admin.memberInfo.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressDTO implements java.io.Serializable {
    private String userCode;
    private String addrCode;
    private String addr;
    private String postNum;
    private String name;
    private String tel;
}
