package com.clicklearner.ms_resultat.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseByDevoirRequestDto {
    private int userId;
    private int devoirId;
}
