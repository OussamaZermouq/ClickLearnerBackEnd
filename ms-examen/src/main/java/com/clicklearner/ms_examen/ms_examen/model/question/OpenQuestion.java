package com.clicklearner.ms_examen.ms_examen.model.question;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue(value="OVT")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenQuestion extends Question{
    private String title;
    private String question;
}
