package com.clicklearner.ms_devoir.DTO;

import com.clicklearner.ms_devoir.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DevoirDTO {
    private int devoirId;
    private String title;
    private LocalDate deadline;
    private int coursId;
    private UserDto prof;
    private List<Question> questions;
}