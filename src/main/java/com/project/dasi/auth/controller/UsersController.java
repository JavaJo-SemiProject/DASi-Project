package com.project.dasi.auth.controller;

import com.project.dasi.auth.PackageDto;
import com.project.dasi.auth.dto.UserCreateRequest;
import com.project.dasi.auth.entity.Users;
import com.project.dasi.auth.handler.CustomLoginFailHandler;
import com.project.dasi.auth.repository.UserRepository;
import com.project.dasi.auth.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UserServiceImpl usersService;

    @GetMapping
    public PackageDto getPackageDto() {
        PackageDto packageDto = new PackageDto();
        packageDto.setNew(false);
        return packageDto;
    }

    @PostMapping("signup")
    public void createUser(UserCreateRequest userCreateRequest, HttpServletResponse response) throws IOException {
        usersService.createUser(userCreateRequest);
        response.sendRedirect("/login");
    }

    @GetMapping("/logout")
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        response.sendRedirect("/login");
    }




}
