package com.clicklearner.ms_resultat.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue(value="RDV")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultatDevoir extends Resultat{
    private int devoirId;
}
