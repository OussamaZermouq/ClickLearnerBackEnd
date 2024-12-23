package com.clicklearner.ms_resultat.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private int userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
