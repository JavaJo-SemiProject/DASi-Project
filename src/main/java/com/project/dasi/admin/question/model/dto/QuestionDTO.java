package com.project.dasi.admin.question.model.dto;



import com.project.dasi.auth.model.dto.UserDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionDTO implements java.io.Serializable {
    private int questNum;
    private UserDTO userCode;
    private String user;
    private QuestionCategoryDTO qCateCode;
    private String qCate;
    private String answerDate;
    private String answerContent;
    private String questDate;
    private String questTitle;
    private String questContent;
}