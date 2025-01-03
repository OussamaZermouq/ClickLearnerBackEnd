package com.clicklearner.ms_devoir.model.userresponse;

import com.clicklearner.ms_devoir.model.question.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "response_type")
public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int responseId;
    @ManyToOne
    private Question question;
    private int userId;
    private Date submittedAt;
}
