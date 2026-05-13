package com.gym.gym_management.controller;

import com.gym.gym_management.dto.request.DilbarLoginRequest;
import com.gym.gym_management.dto.request.DilbarRegisterRequest;
import com.gym.gym_management.dto.response.DilbarAuthResponse;
import com.gym.gym_management.service.DilbarAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class DilbarAuthController {

    private final DilbarAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<DilbarAuthResponse> register(
            @Valid @RequestBody DilbarRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<DilbarAuthResponse> login(
            @Valid @RequestBody DilbarLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
