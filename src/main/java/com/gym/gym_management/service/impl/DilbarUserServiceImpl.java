package com.gym.gym_management.service.impl;

import com.gym.gym_management.dto.request.DilbarRegisterRequest;
import com.gym.gym_management.dto.response.DilbarUserResponse;
import com.gym.gym_management.entity.DilbarUser;
import com.gym.gym_management.mapper.DilbarUserMapper;
import com.gym.gym_management.repository.DilbarUserRepository;
import com.gym.gym_management.service.DilbarUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DilbarUserServiceImpl implements DilbarUserService {

    private final DilbarUserRepository userRepository;
    private final DilbarUserMapper userMapper;

    @Override
    public DilbarUserResponse getById(Long id) {
        return userMapper.toResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public List<DilbarUserResponse> getAll() {
        return userRepository.findAll().stream().map(userMapper::toResponse).toList();
    }

    @Override
    public DilbarUserResponse update(Long id, DilbarRegisterRequest request) {
        DilbarUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
