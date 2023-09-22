package com.project.dasi.auth.entity;

import com.project.dasi.auth.enumeration.Userrole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
public class Users implements UserDetails {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_CODE")
    private String usercode;*/
    @Id
    @Column
    private String userid;

    @Column
    private String password;

    /*@Column(name="USER_NAME")
    private String username;

    @Column(name="BIRTH_DATE")
    private String birthdate;*/

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Userrole userrole;

    @Builder
    private Users(String userid, String password, String email, Userrole userrole) {
        this.userid = userid;
        this.password = password;
        this.email = email;
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
