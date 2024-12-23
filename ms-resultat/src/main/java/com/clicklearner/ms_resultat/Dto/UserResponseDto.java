package com.clicklearner.ms_resultat.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Builder
public class UserResponseDto {
    private int responseId;
    private QuestionDto question;
    private int userId;
    private Date submittedAt;
    private ChoixDto selectedChoice;

}
