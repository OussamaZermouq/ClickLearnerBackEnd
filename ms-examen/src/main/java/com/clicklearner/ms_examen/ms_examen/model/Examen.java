package com.clicklearner.ms_examen.ms_examen.model;

import com.clicklearner.ms_examen.ms_examen.model.question.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int examenId;
    private String title;

    //in minutes
    private int duration;
    private int coursId;
    @OneToMany(mappedBy = "examen",cascade = CascadeType.ALL)
    private List<Question> questions;
}
