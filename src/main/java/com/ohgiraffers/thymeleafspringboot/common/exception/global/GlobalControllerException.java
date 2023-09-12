package com.ohgiraffers.thymeleafspringboot.common.exception.global;

import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRegistException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 모든 컨트롤러에서 발생하는 예외를 일괄적으로 처리
public class GlobalControllerException {



    @ExceptionHandler(NoticeRegistException.class) // 컨트롤러마다 발생하는 예외를 개별적으로 처리
    public String noticeErrorHandler(Model model, NoticeRegistException e){

        model.addAttribute("exception", "notice | " + e.getMessage());
        System.out.println("Notice Exception = " + "공지사항 등록 실패");
        return "content/common/exception";
    }

    @ExceptionHandler(value = Exception.class) // 컨트롤러마다 발생하는 예외를 개별적으로 처리
    public String defaultErrorHandler(Model model, Exception e){

        model.addAttribute("exception", e.getMessage());
        System.out.println("eeee = " + e.getMessage());
        return "content/common/exception";
    }
}
