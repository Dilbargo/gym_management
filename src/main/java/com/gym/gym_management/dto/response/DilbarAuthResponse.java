package com.gym.gym_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DilbarAuthResponse {
    private String token;
    private String username;
    private String role;
}
