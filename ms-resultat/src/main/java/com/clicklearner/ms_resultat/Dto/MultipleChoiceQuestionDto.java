package com.clicklearner.ms_resultat.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleChoiceQuestionDto extends QuestionDto{
    private String question;
    private ChoixDto correctAnswer;
    private List<ChoixDto> choixList;
}
