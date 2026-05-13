package com.gym.gym_management.mapper;

import com.gym.gym_management.dto.request.DilbarTrainerRequest;
import com.gym.gym_management.dto.response.DilbarTrainerResponse;
import com.gym.gym_management.entity.DilbarTrainer;
import org.springframework.stereotype.Component;

@Component
public class DilbarTrainerMapper {
    public DilbarTrainerResponse toResponse(DilbarTrainer trainer) {
        DilbarTrainerResponse response = new DilbarTrainerResponse();
        response.setId(trainer.getId());
        response.setFullName(trainer.getFullName());
        response.setSpecialization(trainer.getSpecialization());
        response.setBio(trainer.getBio());
        response.setPhotoPath(trainer.getPhotoPath());
        response.setCreatedAt(trainer.getCreatedAt());
        return response;
    }
    public DilbarTrainer toEntity(DilbarTrainerRequest request) {
        DilbarTrainer trainer = new DilbarTrainer();
        trainer.setFullName(request.getFullName());
        trainer.setSpecialization(request.getSpecialization());
        trainer.setBio(request.getBio());
        return trainer;
    }
}
