package com.clicklearner.ms_cours.model;


import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Document {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long documentId;
    private String nomDocument;
    private String urlDocument;

    @ManyToOne
    private Cours cours;
}
