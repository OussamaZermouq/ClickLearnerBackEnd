package com.clicklearner.ms_resultat.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DevoirDto {
    private int devoirId;
    private String title;
    private LocalDate deadline;
    private int coursId;
    private UserDto prof;
    private List<QuestionDto> questions;
}
