package com.clicklearner.ms_resultat.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenQuestionDto extends QuestionDto{
    private String title;
    private String question;
}
