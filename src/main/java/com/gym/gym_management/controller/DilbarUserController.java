package com.gym.gym_management.controller;

import com.gym.gym_management.dto.request.DilbarRegisterRequest;
import com.gym.gym_management.dto.response.DilbarUserResponse;
import com.gym.gym_management.service.DilbarUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class DilbarUserController {

    private final DilbarUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<DilbarUserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DilbarUserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DilbarUserResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody DilbarRegisterRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
