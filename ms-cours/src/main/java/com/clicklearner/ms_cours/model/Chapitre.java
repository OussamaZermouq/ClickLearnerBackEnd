package com.clicklearner.ms_cours.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Chapitre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long chapitreId;
    private String titreChapitre;
    private int numChapitre;

    @ManyToOne
    @JsonBackReference
    private Cours cours;

}
