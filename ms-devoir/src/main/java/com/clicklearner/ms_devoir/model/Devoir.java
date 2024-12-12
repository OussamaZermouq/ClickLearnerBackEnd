package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Devoir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int devoirId;
    private String title;
    private LocalDate deadline;
    private int coursId;
}
