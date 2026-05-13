package com.gym.gym_management.service;

import com.gym.gym_management.dto.request.DilbarScheduleRequest;
import com.gym.gym_management.dto.response.DilbarScheduleResponse;

import java.util.List;

public interface DilbarScheduleService {
    DilbarScheduleResponse create(DilbarScheduleRequest request);
    DilbarScheduleResponse getById(Long id);
    List<DilbarScheduleResponse> getAll();
    DilbarScheduleResponse update(Long id, DilbarScheduleRequest request);
    void delete(Long id);
}
