package com.clicklearner.ms_cours.dto;

import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.model.Cours;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class DocumentDto {

    //private Long documentId;
    private String nomDocument;
    private byte[] urlDocument;
    private Long chapitreId;
}
