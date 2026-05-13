package com.gym.gym_management.service.impl;

import com.gym.gym_management.dto.request.DilbarSubscriptionRequest;
import com.gym.gym_management.dto.response.DilbarSubscriptionResponse;
import com.gym.gym_management.entity.DilbarSubscription;
import com.gym.gym_management.entity.DilbarUser;
import com.gym.gym_management.mapper.DilbarSubscriptionMapper;
import com.gym.gym_management.repository.DilbarSubscriptionRepository;
import com.gym.gym_management.repository.DilbarUserRepository;
import com.gym.gym_management.service.DilbarAsyncService;
import com.gym.gym_management.service.DilbarSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DilbarSubscriptionServiceImpl implements DilbarSubscriptionService {

    private final DilbarSubscriptionRepository subscriptionRepository;
    private final DilbarSubscriptionMapper subscriptionMapper;
    private final DilbarUserRepository userRepository;
    private final DilbarAsyncService asyncService;

    @Override
    public DilbarSubscriptionResponse create(DilbarSubscriptionRequest request) {
        DilbarUser user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        DilbarSubscription subscription = subscriptionMapper.toEntity(request);
        subscription.setUser(user);
        DilbarSubscription saved = subscriptionRepository.save(subscription);
        asyncService.logSubscriptionCreated(user.getUsername(), saved.getPlan());
        return subscriptionMapper.toResponse(saved);
    }

    @Override
    public DilbarSubscriptionResponse getById(Long id) {
        return subscriptionMapper.toResponse(subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found")));
    }

    @Override
    public List<DilbarSubscriptionResponse> getAll() {
        return subscriptionRepository.findAll().stream().map(subscriptionMapper::toResponse).toList();
    }

    @Override
    public DilbarSubscriptionResponse update(Long id, DilbarSubscriptionRequest request) {
        DilbarSubscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        subscription.setPlan(request.getPlan());
        subscription.setStartDate(request.getStartDate());
        subscription.setEndDate(request.getEndDate());
        subscription.setPrice(request.getPrice());
        return subscriptionMapper.toResponse(subscriptionRepository.save(subscription));
    }

    @Override
    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
