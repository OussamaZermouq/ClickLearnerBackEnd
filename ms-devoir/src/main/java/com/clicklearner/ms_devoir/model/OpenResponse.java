package com.clicklearner.ms_devoir.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("OVT")
public class OpenResponse extends UserResponse {
    @Column(length = 1000)
    private String textResponse;
}
