package com.project.dasi.admin.question.model.dto;



import com.project.dasi.auth.model.dto.UserDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionDTO implements java.io.Serializable {
    private int questNum; /*QUEST_NUM*/
    private UserDTO userCode; /*USER_CODE*/
    private String user;
    private QuestionCategoryDTO qCateCode;  /*QCATE_CODE*/
    private String qCate;
    private String answerDate;  /*ANSWER_DATE*/
    private String answerContent;   /*ANSWER_CONTENT*/
    private String questDate;  /*QUEST_DATE*/
    private String questTitle;  /*QUEST_TITLE*/
    private String questContent;  /*QUEST_CONTENT*/
}