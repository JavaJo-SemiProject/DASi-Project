package com.project.dasi.question.model.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionListDTO implements java.io.Serializable {
    private String questId;
    private String userCode;
    private int qCateCode;
    private String answerStatus;
    private String answerDate;
    private String answerContent;
    private String questDate;
    private String questContent;
    private String questTitle;
}
