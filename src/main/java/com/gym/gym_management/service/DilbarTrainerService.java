package com.gym.gym_management.service;

import com.gym.gym_management.dto.request.DilbarTrainerRequest;
import com.gym.gym_management.dto.response.DilbarTrainerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DilbarTrainerService {
    DilbarTrainerResponse create(DilbarTrainerRequest request);
    DilbarTrainerResponse getById(Long id);
    List<DilbarTrainerResponse> getAll();
    DilbarTrainerResponse update(Long id, DilbarTrainerRequest request);
    void delete(Long id);
    String uploadPhoto(Long id, MultipartFile file);
}
