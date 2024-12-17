package com.clicklearner.ms_cours.dto;

import com.clicklearner.ms_cours.model.Cours;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class ChapitreDto {
    //private Long chapitreId;
    private String titreChapitre;
    private int numChapitre;
    private Cours cours;
}
