package com.clicklearner.ms_cours.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long coursId;
    private String titreCour;
    private String profId;

    @ManyToOne
    private Matier matier;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    private List<Chapitre> chapitres;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    private List<Document> documents;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    private List<Video> videos;
}
