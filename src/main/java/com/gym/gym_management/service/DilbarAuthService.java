package com.gym.gym_management.service;

import com.gym.gym_management.dto.request.DilbarLoginRequest;
import com.gym.gym_management.dto.request.DilbarRegisterRequest;
import com.gym.gym_management.dto.response.DilbarAuthResponse;

public interface DilbarAuthService {
    DilbarAuthResponse register(DilbarRegisterRequest request);
    DilbarAuthResponse login(DilbarLoginRequest request);
}
