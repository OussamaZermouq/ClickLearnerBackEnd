package com.clicklearner.ms_resultat.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoixDto {
    private int choixId;
    private String choix;
    private MultipleChoiceQuestionDto question;
}
