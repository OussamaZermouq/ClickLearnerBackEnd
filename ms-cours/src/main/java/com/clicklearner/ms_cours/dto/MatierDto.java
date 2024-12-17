package com.clicklearner.ms_cours.dto;


import com.clicklearner.ms_cours.model.Cours;
import lombok.*;

import java.util.List;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class MatierDto {
    //private Long matierId;
    private String nomMatier;
    private List<Cours> cours;
}
