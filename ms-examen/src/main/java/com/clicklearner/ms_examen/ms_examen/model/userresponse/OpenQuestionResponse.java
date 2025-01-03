package com.clicklearner.ms_examen.ms_examen.model.userresponse;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("OVT")
public class OpenQuestionResponse extends UserResponse {
    @Column(length = 1000)
    private String textResponse;
}
