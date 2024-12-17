package com.clicklearner.ms_resultat.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue(value="REM")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultatExamen extends Resultat{
    private int examenId;
}
