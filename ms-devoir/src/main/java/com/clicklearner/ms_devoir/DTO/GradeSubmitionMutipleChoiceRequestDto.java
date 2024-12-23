package com.clicklearner.ms_devoir.DTO;


import lombok.Data;

@Data
public class GradeSubmitionMutipleChoiceRequestDto {
    private int questionId;
    private int studentId;
    private int choixId;
}
