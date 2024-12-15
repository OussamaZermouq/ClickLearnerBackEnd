package com.clicklearner.ms_cours.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Matier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long matierId;
    private String nomMatier;

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    private List<Cours> cours;
}
