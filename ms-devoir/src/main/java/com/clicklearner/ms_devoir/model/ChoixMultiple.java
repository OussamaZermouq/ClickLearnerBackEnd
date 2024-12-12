package com.clicklearner.ms_devoir.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value="QCM")
public class ChoixMultiple extends Devoir{
    private String question;
    @OneToMany
    private List<Choix> choixList;
    @OneToOne
    private Reponse reponse;
}
