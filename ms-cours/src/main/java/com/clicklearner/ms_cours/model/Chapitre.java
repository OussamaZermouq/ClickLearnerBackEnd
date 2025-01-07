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
    private String chapitreDescription;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String chapitreContent;

    @ManyToOne
    @JsonBackReference
    private Cours cours;

    @OneToMany(mappedBy = "chapitre", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Document> documents;


}
