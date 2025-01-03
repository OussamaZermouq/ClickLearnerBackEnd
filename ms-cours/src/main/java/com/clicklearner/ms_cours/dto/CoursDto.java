package com.clicklearner.ms_cours.dto;

import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.model.Video;
import lombok.*;

import java.util.List;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class CoursDto {

    //private Long coursId;
    private String titreCour;
    private String profId;
    private Matier matier;
    private List<Chapitre> chapitres;
    private List<Document> documents;
    private List<Video> videos;
}
