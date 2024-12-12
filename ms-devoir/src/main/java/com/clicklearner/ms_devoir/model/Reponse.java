package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reponseId;
    @OneToOne
    private ChoixMultiple question;
}
