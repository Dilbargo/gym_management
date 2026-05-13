package com.gym.gym_management.controller;

import com.gym.gym_management.dto.request.DilbarSubscriptionRequest;
import com.gym.gym_management.dto.response.DilbarSubscriptionResponse;
import com.gym.gym_management.service.DilbarSubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class DilbarSubscriptionController {

    private final DilbarSubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<DilbarSubscriptionResponse> create(
            @Valid @RequestBody DilbarSubscriptionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DilbarSubscriptionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DilbarSubscriptionResponse>> getAll() {
        return ResponseEntity.ok(subscriptionService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DilbarSubscriptionResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody DilbarSubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subscriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
