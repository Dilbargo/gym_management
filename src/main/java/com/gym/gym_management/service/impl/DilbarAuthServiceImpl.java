package com.gym.gym_management.service.impl;

import com.gym.gym_management.dto.request.DilbarLoginRequest;
import com.gym.gym_management.dto.request.DilbarRegisterRequest;
import com.gym.gym_management.dto.response.DilbarAuthResponse;
import com.gym.gym_management.entity.DilbarUser;
import com.gym.gym_management.enums.DilbarRole;
import com.gym.gym_management.repository.DilbarUserRepository;
import com.gym.gym_management.service.DilbarAsyncService;
import com.gym.gym_management.service.DilbarAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DilbarAuthServiceImpl implements DilbarAuthService {

    private final DilbarUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final DilbarJwtUtil jwtUtil;
    private final DilbarAsyncService asyncService;

    @Override
    public DilbarAuthResponse register(DilbarRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email already exists");
        DilbarUser user = new DilbarUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : DilbarRole.USER);
        userRepository.save(user);
        asyncService.sendWelcomeNotification(user.getUsername());
        String token = jwtUtil.generateToken(user.getUsername());
        return new DilbarAuthResponse(token, user.getUsername(), user.getRole().name());
    }

    @Override
    public DilbarAuthResponse login(DilbarLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        DilbarUser user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtUtil.generateToken(user.getUsername());
        return new DilbarAuthResponse(token, user.getUsername(), user.getRole().name());
    }
}
