package com.clicklearner.ms_cours.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long coursId;
    private String titreCours;
    @Column(length = 1000)
    private String descriptionCours;
    private int profId;
    private DifficultyEnum difficulty;
    private int estimatedDuration;

    @ManyToOne
    @JsonBackReference
    private Matier matier;
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Chapitre> chapitres;
    private String coursImage;
}
