package com.project.dasi.auth.model.service;

import com.project.dasi.auth.model.dto.UserDTO;
import com.project.dasi.auth.member.MemberRegistException;

public interface memberService {

    public void registMember(UserDTO member) throws MemberRegistException;
}
