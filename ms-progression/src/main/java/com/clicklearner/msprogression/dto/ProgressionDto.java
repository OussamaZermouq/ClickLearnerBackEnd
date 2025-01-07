package com.clicklearner.msprogression.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProgressionDto {
    private Long progressionId;
    private Double progression;
    private CoursDto coursDto;
    private UserDto studentDto;
}
