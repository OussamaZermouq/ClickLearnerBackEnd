package com.clicklearner.ms_resultat.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserQuestionPointDto {
    private int questionId;
    private int userId;
    private int point;

}
