package com.project.dasi.auth.entity;

import com.project.dasi.auth.enumeration.Userrole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
@DynamicInsert
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_CODE")
    private String usercode;

    @Column(name="USER_ID")
    private String userid;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="USER_NAME")
    private String username;

    @Column(name="BIRTH_DATE")
    private String birthdate;

    @Column(name="EMAIL")
    private String email;

    @NotBlank(message = "휴대폰 번호를 입력해 주세요.")
    @Column(name="TEL")
    private String tel;

    @Column(name="GENDER")
    private String gender;

    @Column(name="JOIN_DATE")
    private String joindate;

    @Column(name="WITHDRAW_STATUS")
    private String withdrawstatus;

    @Column(name="WITHDRAW_DATE")
    private String withdrawdate;

    @Column(name="USER_ROLE")
    @Enumerated(EnumType.STRING)
    private Userrole userrole;

    @Builder
    public Users(String usercode, String userid, String password, String username, String birthdate, String email, String tel, String gender, String marketingstatus, String joindate, String withdrawstatus, String withdrawdate, Userrole userrole) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 계정의 권한 목록을 리턴
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(userrole.getValue()));
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password; // 계정의 비밀번호 리턴
    }

    @Override
    public String getUsername() {
        return this.userid; // 계정의 고유한 값 리턴
    }


    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정의 만료 여부 리턴
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정의 잠김 여부 리턴
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // 비밀번호 만료 여부 리턴
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정의 활성화 여부 리턴
    }

}
