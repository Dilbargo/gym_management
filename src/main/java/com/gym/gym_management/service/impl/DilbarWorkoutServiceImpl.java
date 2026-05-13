package com.gym.gym_management.service.impl;

import com.gym.gym_management.dto.request.DilbarWorkoutRequest;
import com.gym.gym_management.dto.response.DilbarWorkoutResponse;
import com.gym.gym_management.entity.DilbarTrainer;
import com.gym.gym_management.entity.DilbarUser;
import com.gym.gym_management.entity.DilbarWorkout;
import com.gym.gym_management.mapper.DilbarWorkoutMapper;
import com.gym.gym_management.repository.DilbarTrainerRepository;
import com.gym.gym_management.repository.DilbarUserRepository;
import com.gym.gym_management.repository.DilbarWorkoutRepository;
import com.gym.gym_management.service.DilbarWorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DilbarWorkoutServiceImpl implements DilbarWorkoutService {

    private final DilbarWorkoutRepository workoutRepository;
    private final DilbarWorkoutMapper workoutMapper;
    private final DilbarTrainerRepository trainerRepository;
    private final DilbarUserRepository userRepository;

    @Override
    public DilbarWorkoutResponse create(DilbarWorkoutRequest request) {
        DilbarTrainer trainer = trainerRepository.findById(request.getTrainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        DilbarWorkout workout = workoutMapper.toEntity(request);
        workout.setTrainer(trainer);
        return workoutMapper.toResponse(workoutRepository.save(workout));
    }

    @Override
    public DilbarWorkoutResponse getById(Long id) {
        return workoutMapper.toResponse(workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found")));
    }

    @Override
    public List<DilbarWorkoutResponse> getAll() {
        return workoutRepository.findAll().stream().map(workoutMapper::toResponse).toList();
    }

    @Override
    public DilbarWorkoutResponse update(Long id, DilbarWorkoutRequest request) {
        DilbarWorkout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        workout.setTitle(request.getTitle());
        workout.setDescription(request.getDescription());
        workout.setScheduledAt(request.getScheduledAt());
        workout.setDurationMinutes(request.getDurationMinutes());
        return workoutMapper.toResponse(workoutRepository.save(workout));
    }

    @Override
    public void delete(Long id) {
        workoutRepository.deleteById(id);
    }

    @Override
    public Page<DilbarWorkoutResponse> search(String title, Long trainerId, Pageable pageable) {
        Page<DilbarWorkout> workouts;
        if (title != null && !title.isEmpty()) {
            workouts = workoutRepository.findByTitleContainingIgnoreCase(title, pageable);
        } else if (trainerId != null) {
            workouts = workoutRepository.findByTrainerId(trainerId, pageable);
        } else {
            workouts = workoutRepository.findAll(pageable);
        }
        return workouts.map(workoutMapper::toResponse);
    }

    @Override
    public DilbarWorkoutResponse addParticipant(Long workoutId, Long userId) {
        DilbarWorkout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        DilbarUser user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        workout.getParticipants().add(user);
        return workoutMapper.toResponse(workoutRepository.save(workout));
    }
}
