package com.clicklearner.ms_examen.ms_examen.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {
    private HttpStatus code;
    private String message;

}
