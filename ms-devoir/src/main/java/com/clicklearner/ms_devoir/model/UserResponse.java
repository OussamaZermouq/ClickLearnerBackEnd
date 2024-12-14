package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "response_type")
public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reponseId;

    @ManyToOne
    private Question question;

    private int userId;
    private LocalDateTime submittedAt;
}
