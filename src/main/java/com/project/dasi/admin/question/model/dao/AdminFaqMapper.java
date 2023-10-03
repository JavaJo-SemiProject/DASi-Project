package com.project.dasi.admin.question.model.dao;

import com.project.dasi.admin.question.model.dto.AdminFaqDTO;
import com.project.dasi.question.model.dto.FaqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminFaqMapper {

    List<AdminFaqDTO> adminSelectAllFaqList();

    AdminFaqDTO adminSelectOneFaqList(int faqNum);

    int adminFaqUpdateRegist(AdminFaqDTO adminfaq);

    int adminFaqCreate(AdminFaqDTO createdto);

    int adminFaqDelete(int faqNum);


}
