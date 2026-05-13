package com.gym.gym_management.controller;

import com.gym.gym_management.dto.request.DilbarTrainerRequest;
import com.gym.gym_management.dto.response.DilbarTrainerResponse;
import com.gym.gym_management.service.DilbarTrainerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
public class DilbarTrainerController {

    private final DilbarTrainerService trainerService;

    @PostMapping
    public ResponseEntity<DilbarTrainerResponse> create(
            @Valid @RequestBody DilbarTrainerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trainerService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DilbarTrainerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DilbarTrainerResponse>> getAll() {
        return ResponseEntity.ok(trainerService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DilbarTrainerResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody DilbarTrainerRequest request) {
        return ResponseEntity.ok(trainerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trainerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadPhoto(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(trainerService.uploadPhoto(id, file));
    }
}
