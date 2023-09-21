package com.project.dasi.admin.memberInfo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dasi.admin.memberInfo.model.dto.MemberDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class JacksonController {
    private final List<MemberDTO> memberJacksonList;


    public JacksonController() {
        memberJacksonList = new ArrayList<>();
    }

    /* 2. @ResponseBody를 이용한 반환 */
    @GetMapping(value = "jacksonListButton", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getMemberListOnResponseBody() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(memberJacksonList);
    }

}
