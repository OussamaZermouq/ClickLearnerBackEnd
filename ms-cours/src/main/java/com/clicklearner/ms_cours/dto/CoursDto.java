package com.clicklearner.ms_cours.dto;

import com.clicklearner.ms_cours.dto.user.ProfDto;
import com.clicklearner.ms_cours.model.*;
import lombok.*;

import java.util.List;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class CoursDto {

    private Long coursId;
    private String titreCours;
    private ProfDto prof;
    private Matier matier;
    private String coursImage;
    private String descriptionCours;
    private DifficultyEnum difficulty;
    private int estimatedDuration;
    private List<Chapitre> chapitres;
    private List<Document> documents;
    private List<Video> videos;

}
