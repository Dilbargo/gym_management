package com.gym.gym_management.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DilbarAsyncService {

    @Async
    public CompletableFuture<String> sendWelcomeNotification(String username) {
        log.info("Welcome notification sent to: {}", username);
        return CompletableFuture.completedFuture("Welcome " + username);
    }

    @Async
    public CompletableFuture<String> logSubscriptionCreated(String username, String plan) {
        log.info("Subscription '{}' created for user: {}", plan, username);
        return CompletableFuture.completedFuture("Subscription created");
    }

    @Async
    public CompletableFuture<String> logWorkoutJoined(String username, String workout) {
        log.info("User '{}' joined workout: {}", username, workout);
        return CompletableFuture.completedFuture("Workout joined");
    }
}
