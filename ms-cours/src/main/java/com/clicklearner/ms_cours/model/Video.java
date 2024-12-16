package com.clicklearner.ms_cours.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long videoId;
    private String nomVideo;
    private String urlVideo;

    @ManyToOne
    @JsonBackReference
    private Cours cours;

}
