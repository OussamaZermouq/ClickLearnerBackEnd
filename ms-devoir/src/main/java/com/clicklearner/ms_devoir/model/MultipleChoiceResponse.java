package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("QCM")
public class MultipleChoiceResponse extends UserResponse {
    @OneToOne
    private Choix selectedChoice;
}

