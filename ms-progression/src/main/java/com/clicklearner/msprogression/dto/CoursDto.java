package com.clicklearner.msprogression.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoursDto {
    private Long coursId;
    private String titreCours;
    @Column(length = 1000)
    private String descriptionCours;
    private int profId;
    private String difficulty;
    private int estimatedDuration;
    private String coursImage;
}
