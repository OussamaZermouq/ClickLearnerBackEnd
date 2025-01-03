package com.clicklearner.ms_examen.ms_examen.model.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int choixId;
    private String choix;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private MultipleChoiceQuestion question;
}
