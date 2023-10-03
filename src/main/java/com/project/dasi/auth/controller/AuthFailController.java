package com.project.dasi.auth.controller;


import com.project.dasi.auth.model.dao.UserMapper;
import com.project.dasi.auth.model.dto.UserDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Configuration
public class AuthFailController extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        UserDTO userDTO = null;
        String errorMessage;
        if(exception instanceof BadCredentialsException) {
            errorMessage = "아이디 또는 비밀번호가 맞지 않습니다.";
        } else if(exception instanceof InternalAuthenticationServiceException) {
            errorMessage = "서버에서 오류가 발생하였습니다.\n 관리자에게 문의해 주세요.";
        } else if(exception instanceof UsernameNotFoundException) {
            errorMessage = "존재하지 않는 회원입니다.\n 아이디를 확인해 주세요.";
        } else if(exception instanceof AuthenticationCredentialsNotFoundException) {
            errorMessage = "인증 요청이 거부되었습니다.\n 관리자에게 문의해 주세요.";
        } else if(exception instanceof DisabledException) {
            errorMessage = "계정이 비활성화되어 인증 요청이 거부되었습니다.";
        } else {
            errorMessage = "알 수 없는 오류로 로그인 처리가 불가합니다.\n 관리자에게 문의해 주세요.";
            exception.printStackTrace();
        }

        errorMessage = URLEncoder.encode(errorMessage, "UTF-8");
        setDefaultFailureUrl("/content/member/fail?errorMessage=" + errorMessage);

        super.onAuthenticationFailure(request, response, exception);
    }
}