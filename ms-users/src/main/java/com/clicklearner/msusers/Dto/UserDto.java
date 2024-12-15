package com.clicklearner.msusers.Dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {
    private int userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
