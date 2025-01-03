package com.clicklearner.ms_cours.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "chapitres", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Document> documents;

    @OneToMany(mappedBy = "chapitres", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Video> videos;

}
