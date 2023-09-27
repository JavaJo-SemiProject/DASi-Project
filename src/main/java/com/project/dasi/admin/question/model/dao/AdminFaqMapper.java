package com.project.dasi.admin.question.model.dao;

import com.project.dasi.admin.question.model.dto.AdminFaqDTO;
import com.project.dasi.question.model.dto.FaqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminFaqMapper {    /*이 이름 가진 매퍼.xml파일 찾아가서 해당 메서드와 id같은거 찾아서 실행*/

    List<AdminFaqDTO> adminSelectAllFaqList();

    AdminFaqDTO adminSelectOneFaqList(int faqNum);

    int adminFaqUpdateRegist(AdminFaqDTO adminfaq);

    int adminFaqCreate(AdminFaqDTO createdto);

    int adminFaqDelete(int faqNum);



    /*int updateFaq(AdminFaqDTO adminfaq);*/


}
