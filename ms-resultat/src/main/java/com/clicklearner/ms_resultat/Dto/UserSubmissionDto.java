package com.clicklearner.ms_resultat.Dto;

import lombok.Data;

@Data
public class UserSubmissionDto {
    private int questionId;
    private int studentId;
    private int choixId;
}
