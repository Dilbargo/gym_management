package com.gym.gym_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DilbarSubscriptionResponse {
    private Long id;
    private String plan;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String username;
}
