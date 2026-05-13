package com.gym.gym_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DilbarTrainerResponse {
    private Long id;
    private String fullName;
    private String specialization;
    private String bio;
    private String photoPath;
    private LocalDateTime createdAt;
}
