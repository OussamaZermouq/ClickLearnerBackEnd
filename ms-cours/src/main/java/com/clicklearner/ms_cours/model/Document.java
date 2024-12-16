package com.clicklearner.ms_cours.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Cours cours;
}
