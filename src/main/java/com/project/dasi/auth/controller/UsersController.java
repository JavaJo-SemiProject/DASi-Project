package com.project.dasi.auth.controller;

import com.project.dasi.auth.model.PackageDto;
import com.project.dasi.auth.model.dto.UserCreateRequest;
import com.project.dasi.auth.model.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UserServiceImpl usersService;

    @GetMapping
    public PackageDto getPackageDto() {
        PackageDto packageDto = new PackageDto();
        packageDto.setNew(false);
        return packageDto;
    }

    @GetMapping("/signup/{userid}/exists")
    public ResponseEntity<Boolean> checkUseridDuplicate(@PathVariable String userid){
        return ResponseEntity.ok(usersService.checkUseridDuplication(userid));
    }


    @PostMapping("signup/check")
    public String createUser(
            @Valid UserCreateRequest userCreateRequest, BindingResult bindingResult, Model model) throws IOException {

        if(bindingResult.hasErrors()) {
            /* 회원가입 실패 시 입력 데이터 값 유지 */
            model.addAttribute("userCreateRequest", userCreateRequest);

            /* 유효성 검사를 통과하지 못 한 필드와 메시지 핸들링 */
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put("valid_"+error.getField(), error.getDefaultMessage());
                log.info("error message : "+error.getDefaultMessage());
            }
            /* 회원가입 페이지로 리턴 */
            return "redirect:/signup";
        }

        usersService.createUser(userCreateRequest);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        response.sendRedirect("/login");
    }

}


