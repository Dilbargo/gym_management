package com.gym.gym_management.controller;

import com.gym.gym_management.dto.request.DilbarScheduleRequest;
import com.gym.gym_management.dto.response.DilbarScheduleResponse;
import com.gym.gym_management.service.DilbarScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class DilbarScheduleController {

    private final DilbarScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<DilbarScheduleResponse> create(
            @Valid @RequestBody DilbarScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DilbarScheduleResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DilbarScheduleResponse>> getAll() {
        return ResponseEntity.ok(scheduleService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DilbarScheduleResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody DilbarScheduleRequest request) {
        return ResponseEntity.ok(scheduleService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scheduleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
