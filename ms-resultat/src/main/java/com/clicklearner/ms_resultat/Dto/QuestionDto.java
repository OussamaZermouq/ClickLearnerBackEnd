package com.clicklearner.ms_resultat.Dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Entity;
import lombok.Data;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MultipleChoiceQuestionDto.class, name = "MultipleChoiceQuestion"),
        @JsonSubTypes.Type(value = OpenQuestionDto.class, name = "OpenQuestion")
})
@Data
public class QuestionDto {
    private int questionId;
    private DevoirDto devoirDto;

}
