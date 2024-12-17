package com.clicklearner.ms_resultat.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetResultatByStudentIdAndByDevoirIdDto {
    public int devoirId;
    public int studentId;
}
