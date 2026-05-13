package com.gym.gym_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DilbarTrainerRequest {
    @NotBlank
    private String fullName;
    @NotBlank
    private String specialization;
    @NotBlank
    private String bio;
}
