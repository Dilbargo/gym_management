package com.gym.gym_management.service;

import com.gym.gym_management.dto.request.DilbarSubscriptionRequest;
import com.gym.gym_management.dto.response.DilbarSubscriptionResponse;

import java.util.List;

public interface DilbarSubscriptionService {
    DilbarSubscriptionResponse create(DilbarSubscriptionRequest request);
    DilbarSubscriptionResponse getById(Long id);
    List<DilbarSubscriptionResponse> getAll();
    DilbarSubscriptionResponse update(Long id, DilbarSubscriptionRequest request);
    void delete(Long id);
}
