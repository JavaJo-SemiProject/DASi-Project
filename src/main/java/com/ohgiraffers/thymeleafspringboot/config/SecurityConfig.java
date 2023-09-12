package com.ohgiraffers.thymeleafspringboot.config;

import com.ohgiraffers.thymeleafspringboot.member.service.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
/* WebSecurityConfigurerAdapter 클래스가 deprecated되어서 상속 받아서 메소드 재정의하는 방법
*  (Bean으로 등록해서 사용하는 방법으로 변경)
*  현재 클래스는 이전 버전에서 사용하는 방법에 대한 예시/참고용 (실제구현할 떄는 수업할 때 했던 소스 이용)
*
* */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        //인증 무시 설정
        web.ignoring().antMatchers("/css/**", "/js/**", "/static/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //권한별 접근 페이지 설정
        http
                .authorizeRequests()
                .mvcMatchers("/notice/**", "/board/**", "/thumbnail/**").hasAnyAuthority("ROLE_MEMBER", "ROLE_ADMIN")
                .mvcMatchers("/notice/regist").hasAnyAuthority("ROLE_ADMIN")
                .mvcMatchers("/**", "/member/**").permitAll()
                .and()
                .csrf().disable();

        //로그인 로그아웃 설정
        http
                    .formLogin()
                    .loginPage("/member/login")             //커스텀 로그인 페이지 사용
                    .defaultSuccessUrl("/")                 //로그인 성공시 이동 페이지
                    .failureUrl("/member/loginfail")
                    .usernameParameter("memberId")			// 아이디 파라미터명 설정
                    .passwordParameter("memberPwd")			// 패스워드 파라미터명 설정
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/");

    }

}
