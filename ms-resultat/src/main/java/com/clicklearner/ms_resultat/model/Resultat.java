package com.clicklearner.ms_resultat.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ResultatDevoir.class, name = "ResultatDevoir"),
        @JsonSubTypes.Type(value = ResultatExamen.class, name = "ResultatExamen")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resultatId;
    private int studentId;
    private int grade;
}
