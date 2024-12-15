package com.clicklearner.ms_devoir.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Devoir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int devoirId;
    private String title;
    private LocalDate deadline;
    private int coursId;
    private int profId;
    @OneToMany(mappedBy = "devoir",cascade = CascadeType.ALL)
    private List<Question> questions;
}
