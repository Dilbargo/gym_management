package com.gym.gym_management.service;

import com.gym.gym_management.dto.request.DilbarRegisterRequest;
import com.gym.gym_management.dto.response.DilbarUserResponse;

import java.util.List;

public interface DilbarUserService {
    DilbarUserResponse getById(Long id);
    List<DilbarUserResponse> getAll();
    DilbarUserResponse update(Long id, DilbarRegisterRequest request);
    void delete(Long id);
}
