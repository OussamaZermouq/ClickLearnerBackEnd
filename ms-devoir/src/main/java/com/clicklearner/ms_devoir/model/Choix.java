package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int choixId;
    private String choix;

    @ManyToOne
    private ChoixMultiple question;
}
