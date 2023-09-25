package com.project.dasi.question.model.dao;

import com.project.dasi.question.model.dto.FaqDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*동일한명의 FaqMapper.xml에가서 실행하고, 그 결과를
List<FaqDTO> selectAllFaqList();에 담는다. 이게 아래
List<FaqDTO> selectAllFaqList(); 메서드의 역할임.*/
@Mapper
public interface FaqMapper {
    List<FaqDTO> selectAllFaqList();  /*FaqMapper 에 있는 이 이름을 가진 select 를 찾아가라!select id= 가
     이 이름인 것의 결과를 가져와라*/
}
