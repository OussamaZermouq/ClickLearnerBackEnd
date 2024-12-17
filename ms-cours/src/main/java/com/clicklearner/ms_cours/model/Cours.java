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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long coursId;
    private String titreCour;
    private String profId;

    @ManyToOne
    @JsonBackReference
    private Matier matier;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Chapitre> chapitres;

}
