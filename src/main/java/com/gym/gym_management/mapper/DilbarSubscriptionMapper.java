package com.gym.gym_management.mapper;

import com.gym.gym_management.dto.request.DilbarSubscriptionRequest;
import com.gym.gym_management.dto.response.DilbarSubscriptionResponse;
import com.gym.gym_management.entity.DilbarSubscription;
import org.springframework.stereotype.Component;

@Component
public class DilbarSubscriptionMapper {
    public DilbarSubscriptionResponse toResponse(DilbarSubscription subscription) {
        DilbarSubscriptionResponse response = new DilbarSubscriptionResponse();
        response.setId(subscription.getId());
        response.setPlan(subscription.getPlan());
        response.setStartDate(subscription.getStartDate());
        response.setEndDate(subscription.getEndDate());
        response.setPrice(subscription.getPrice());
        response.setUsername(subscription.getUser().getUsername());
        return response;
    }
    public DilbarSubscription toEntity(DilbarSubscriptionRequest request) {
        DilbarSubscription subscription = new DilbarSubscription();
        subscription.setPlan(request.getPlan());
        subscription.setStartDate(request.getStartDate());
        subscription.setEndDate(request.getEndDate());
        subscription.setPrice(request.getPrice());
        return subscription;
    }
}
