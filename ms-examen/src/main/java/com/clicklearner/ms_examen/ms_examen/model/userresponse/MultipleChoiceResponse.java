package com.clicklearner.ms_examen.ms_examen.model.userresponse;

import com.clicklearner.ms_examen.ms_examen.model.question.Choix;
import com.clicklearner.ms_examen.ms_examen.model.question.Question;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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

