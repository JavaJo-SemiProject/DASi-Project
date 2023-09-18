package com.project.dasi.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { // 정적 자원에 대해서는 Security 설정을 적용하지 않음.

    private final UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring() // spring security 필터 타지 않도록 무시
                .antMatchers("/resources/**");

    }

    @Override
    @RequestMapping("/")
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login", "/signup").permitAll()   // /login, /signup 은 인증 안해도 접근 가능하도록 설정
                .antMatchers("/admin").hasRole("ADMIN")         // /admin 은 어드민 유저만 가능하도록 설정
                .antMatchers("/my").authenticated()             // /my 은 인증이 되야함
                .and()
                .formLogin()                                                // form 을 통한 login 활성화
                .loginPage("/login")
                .usernameParameter("userid")			// 아이디 파라미터명 설정
                .passwordParameter("password")
                .successForwardUrl("/success")// 로그인 페이지 URL 설정 , 설정하지 않는 경우 default 로그인 페이지 노출
                .failureForwardUrl("/fail")                                 // 로그인 실패 URL 설정
                .and()
                .logout()
                .logoutUrl("/logout");                                       // 로그아웃 URL 설정
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(userDetailsService, bCryptPasswordEncoder());
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider());
    }



}