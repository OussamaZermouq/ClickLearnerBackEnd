package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value="QCM")
public class MultipleChoiceQuestion extends Question{
    private String question;
    @OneToOne(cascade = CascadeType.ALL)
    private Choix correctAnswer;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Choix> choixList;
}
