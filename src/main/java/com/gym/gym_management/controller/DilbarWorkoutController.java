package com.gym.gym_management.controller;

import com.gym.gym_management.dto.request.DilbarWorkoutRequest;
import com.gym.gym_management.dto.response.DilbarWorkoutResponse;
import com.gym.gym_management.service.DilbarWorkoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class DilbarWorkoutController {

    private final DilbarWorkoutService workoutService;

    @PostMapping
    public ResponseEntity<DilbarWorkoutResponse> create(
            @Valid @RequestBody DilbarWorkoutRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DilbarWorkoutResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(workoutService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DilbarWorkoutResponse>> getAll() {
        return ResponseEntity.ok(workoutService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DilbarWorkoutResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody DilbarWorkoutRequest request) {
        return ResponseEntity.ok(workoutService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workoutService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DilbarWorkoutResponse>> search(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long trainerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageRequest.of(page, size,
                sortDir.equalsIgnoreCase("asc")
                        ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending());
        return ResponseEntity.ok(workoutService.search(title, trainerId, pageable));
    }

    @PostMapping("/{workoutId}/participants/{userId}")
    public ResponseEntity<DilbarWorkoutResponse> addParticipant(
            @PathVariable Long workoutId,
            @PathVariable Long userId) {
        return ResponseEntity.ok(workoutService.addParticipant(workoutId, userId));
    }
}
