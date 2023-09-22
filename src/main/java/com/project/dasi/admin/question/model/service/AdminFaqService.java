package com.project.dasi.admin.question.model.service;

import com.project.dasi.admin.question.model.dao.AdminFaqMapper;
import com.project.dasi.admin.question.model.dto.AdminFaqDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminFaqService {
    private final AdminFaqMapper adminFaqMappper;

    public AdminFaqService(AdminFaqMapper adminFaqMappper) {
        this.adminFaqMappper = adminFaqMappper;
    }


    /*FaQ 전체 목록 조회용 메서드*/
    public List<AdminFaqDTO> adminSelectAllFaqList() {

        List<AdminFaqDTO> faqList = adminFaqMappper.adminSelectAllFaqList();

        return faqList;
    }

    public AdminFaqDTO adminSelectOneFaqList(int Num) {

        AdminFaqDTO faqOneList = adminFaqMappper.adminSelectOneFaqList(Num);

        return faqOneList;
    }


    public void adminFaqUpdateRegist(AdminFaqDTO adminfaq) {

        adminFaqMappper.adminFaqUpdateRegist(adminfaq);

    }

    public void adminFaqCreate(AdminFaqDTO createdto) {

        adminFaqMappper.adminFaqCreate(createdto);
    }


    public void adminFaqDelete(int faqNum) {

        adminFaqMappper.adminFaqDelete(faqNum);
    }


}
