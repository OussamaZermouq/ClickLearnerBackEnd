package com.clicklearner.ms_devoir.model.question;

import com.clicklearner.ms_devoir.model.Devoir;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MultipleChoiceQuestion.class, name = "MultipleChoiceQuestion"),
        @JsonSubTypes.Type(value = OpenQuestion.class, name = "OpenQuestion")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    @ManyToOne
    @JsonIgnore
    private Devoir devoir;
}
