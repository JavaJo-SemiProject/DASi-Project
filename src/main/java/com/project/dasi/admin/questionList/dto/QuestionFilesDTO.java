package com.project.dasi.admin.questionList.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionFilesDTO implements java.io.Serializable {
    private String fileCode;
    private String questId;
    private String uploadPath;
    private String originName;
    private String transferName;
    private String ext;
}
