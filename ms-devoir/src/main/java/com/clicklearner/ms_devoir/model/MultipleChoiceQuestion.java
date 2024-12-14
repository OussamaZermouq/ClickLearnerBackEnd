package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value="QCM")
public class MultipleChoiceQuestion extends Question{
    private String question;
    @OneToOne
    private Choix correctAnswer;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Choix> choixList;
}
