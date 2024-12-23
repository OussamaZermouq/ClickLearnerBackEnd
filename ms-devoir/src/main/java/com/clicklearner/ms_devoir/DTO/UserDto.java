package com.clicklearner.ms_devoir.DTO;

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
