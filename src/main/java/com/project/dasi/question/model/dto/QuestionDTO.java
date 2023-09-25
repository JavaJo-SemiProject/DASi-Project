package com.project.dasi.question.model.dto;



import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionDTO implements java.io.Serializable {
    private String questNum; /*QUEST_NUM*/
    private String userCode; /*USER_CODE*/
    private CategoryDTO qcateCode;  /*QCATE_CODE*/
    private String answerDate;  /*ANSWER_DATE*/
    private String answerContent;   /*ANSWER_CONTENT*/
    private String questDate;  /*QUEST_DATE*/
    private String questTitle;  /*QUEST_TITLE*/
    private String questContent;  /*QUEST_CONTENT*/
}