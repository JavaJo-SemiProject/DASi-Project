package com.project.dasi.member.faq.service;

import com.project.dasi.member.faq.dto.FaqDTO;

import java.util.List;

public interface FaqService {
    /*FaQ전체 목록 조회용 메서드*/
    public List<FaqDTO> selectAllFaqList();
}
