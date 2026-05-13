package com.gym.gym_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DilbarErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
