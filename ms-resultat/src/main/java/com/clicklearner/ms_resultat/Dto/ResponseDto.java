package com.clicklearner.ms_resultat.Dto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
public class ResponseDto {
    public HttpStatus code;
    public String message;
}
