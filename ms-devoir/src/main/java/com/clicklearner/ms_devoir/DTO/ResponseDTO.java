package com.clicklearner.ms_devoir.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseDTO {
    public HttpStatus status;
    public String message;
}
