package com.clicklearner.ms_devoir.model;

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
public class Ouvert extends Devoir{
    private String title;
    private String question;
}
