package com.clicklearner.ms_examen.ms_examen.model.question;

import com.clicklearner.ms_examen.ms_examen.model.Examen;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MultipleChoiceQuestion.class, name = "MultipleChoiceQuestion"),
        @JsonSubTypes.Type(value = OpenQuestion.class, name = "OpenQuestion")
})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    private String title;
    @ManyToOne
    //do not use jsonignore use a DTO instead
    private Examen examen;
}
