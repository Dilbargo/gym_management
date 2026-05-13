package com.gym.gym_management.service.impl;

import com.gym.gym_management.dto.request.DilbarTrainerRequest;
import com.gym.gym_management.dto.response.DilbarTrainerResponse;
import com.gym.gym_management.entity.DilbarTrainer;
import com.gym.gym_management.mapper.DilbarTrainerMapper;
import com.gym.gym_management.repository.DilbarTrainerRepository;
import com.gym.gym_management.service.DilbarTrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DilbarTrainerServiceImpl implements DilbarTrainerService {

    private final DilbarTrainerRepository trainerRepository;
    private final DilbarTrainerMapper trainerMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public DilbarTrainerResponse create(DilbarTrainerRequest request) {
        return trainerMapper.toResponse(trainerRepository.save(trainerMapper.toEntity(request)));
    }

    @Override
    public DilbarTrainerResponse getById(Long id) {
        return trainerMapper.toResponse(trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found")));
    }

    @Override
    public List<DilbarTrainerResponse> getAll() {
        return trainerRepository.findAll().stream().map(trainerMapper::toResponse).toList();
    }

    @Override
    public DilbarTrainerResponse update(Long id, DilbarTrainerRequest request) {
        DilbarTrainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        trainer.setFullName(request.getFullName());
        trainer.setSpecialization(request.getSpecialization());
        trainer.setBio(request.getBio());
        return trainerMapper.toResponse(trainerRepository.save(trainer));
    }

    @Override
    public void delete(Long id) {
        trainerRepository.deleteById(id);
    }

    @Override
    public String uploadPhoto(Long id, MultipartFile file) {
        try {
            DilbarTrainer trainer = trainerRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
            String fileName = id + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            trainer.setPhotoPath(filePath.toString());
            trainerRepository.save(trainer);
            return "Photo uploaded: " + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload photo: " + e.getMessage());
        }
    }
}
