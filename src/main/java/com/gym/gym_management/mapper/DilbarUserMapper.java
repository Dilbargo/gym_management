package com.gym.gym_management.mapper;

import com.gym.gym_management.dto.response.DilbarUserResponse;
import com.gym.gym_management.entity.DilbarUser;
import org.springframework.stereotype.Component;

@Component
public class DilbarUserMapper {
    public DilbarUserResponse toResponse(DilbarUser user) {
        DilbarUserResponse response = new DilbarUserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }
}
