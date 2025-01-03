package com.clicklearner.ms_devoir.model.userresponse;

import com.clicklearner.ms_devoir.model.question.Choix;
import com.clicklearner.ms_devoir.model.question.Question;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}

