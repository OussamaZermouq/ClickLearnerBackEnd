package com.clicklearner.msusers.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Prof.class, name = "PRF"),
        @JsonSubTypes.Type(value = Student.class, name = "STU")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
