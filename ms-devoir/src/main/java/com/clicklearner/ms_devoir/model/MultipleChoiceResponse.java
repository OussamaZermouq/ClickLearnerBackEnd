package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("QCM")
public class MultipleChoiceResponse extends UserResponse {
    @OneToOne
    private Choix selectedChoice;

    public MultipleChoiceResponse(int responseId, Question question, int userId, Date submittedAt, Choix selectedChoice) {
        super(responseId, question, userId, submittedAt);
        this.selectedChoice = selectedChoice;
    }

    public MultipleChoiceResponse(Choix selectedChoice) {
        this.selectedChoice = selectedChoice;
    }
}

