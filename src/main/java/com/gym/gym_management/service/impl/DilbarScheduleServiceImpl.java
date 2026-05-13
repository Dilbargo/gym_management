package com.gym.gym_management.service.impl;

import com.gym.gym_management.dto.request.DilbarScheduleRequest;
import com.gym.gym_management.dto.response.DilbarScheduleResponse;
import com.gym.gym_management.entity.DilbarSchedule;
import com.gym.gym_management.entity.DilbarTrainer;
import com.gym.gym_management.entity.DilbarWorkout;
import com.gym.gym_management.mapper.DilbarScheduleMapper;
import com.gym.gym_management.repository.DilbarScheduleRepository;
import com.gym.gym_management.repository.DilbarTrainerRepository;
import com.gym.gym_management.repository.DilbarWorkoutRepository;
import com.gym.gym_management.service.DilbarScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DilbarScheduleServiceImpl implements DilbarScheduleService {

    private final DilbarScheduleRepository scheduleRepository;
    private final DilbarScheduleMapper scheduleMapper;
    private final DilbarWorkoutRepository workoutRepository;
    private final DilbarTrainerRepository trainerRepository;

    @Override
    public DilbarScheduleResponse create(DilbarScheduleRequest request) {
        DilbarWorkout workout = workoutRepository.findById(request.getWorkoutId())
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        DilbarTrainer trainer = trainerRepository.findById(request.getTrainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        DilbarSchedule schedule = scheduleMapper.toEntity(request);
        schedule.setWorkout(workout);
        schedule.setTrainer(trainer);
        return scheduleMapper.toResponse(scheduleRepository.save(schedule));
    }

    @Override
    public DilbarScheduleResponse getById(Long id) {
        return scheduleMapper.toResponse(scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found")));
    }

    @Override
    public List<DilbarScheduleResponse> getAll() {
        return scheduleRepository.findAll().stream().map(scheduleMapper::toResponse).toList();
    }

    @Override
    public DilbarScheduleResponse update(Long id, DilbarScheduleRequest request) {
        DilbarSchedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        schedule.setDayOfWeek(request.getDayOfWeek());
        schedule.setStartTime(request.getStartTime());
        schedule.setEndTime(request.getEndTime());
        return scheduleMapper.toResponse(scheduleRepository.save(schedule));
    }

    @Override
    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}
