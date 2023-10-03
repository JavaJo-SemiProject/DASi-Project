package com.project.dasi.question.model.service;



import com.project.dasi.question.model.dao.FaqMapper;
import com.project.dasi.question.model.dto.FaqDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  FaqService {
    private final FaqMapper faqMapper;

    public FaqService(FaqMapper faqmapper) {this.faqMapper = faqmapper;}

    /*FaQ 전체 목록 조회용 메서드*/
    public List<FaqDTO> selectAllFaqList() {

        List<FaqDTO> faqList = faqMapper.selectAllFaqList();

        return faqList;
    }
}
