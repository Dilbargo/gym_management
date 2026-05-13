package com.gym.gym_management.mapper;

import com.gym.gym_management.dto.request.DilbarWorkoutRequest;
import com.gym.gym_management.dto.response.DilbarWorkoutResponse;
import com.gym.gym_management.entity.DilbarWorkout;
import org.springframework.stereotype.Component;

@Component
public class DilbarWorkoutMapper {
    public DilbarWorkoutResponse toResponse(DilbarWorkout workout) {
        DilbarWorkoutResponse response = new DilbarWorkoutResponse();
        response.setId(workout.getId());
        response.setTitle(workout.getTitle());
        response.setDescription(workout.getDescription());
        response.setScheduledAt(workout.getScheduledAt());
        response.setDurationMinutes(workout.getDurationMinutes());
        response.setTrainerName(workout.getTrainer().getFullName());
        return response;
    }
    public DilbarWorkout toEntity(DilbarWorkoutRequest request) {
        DilbarWorkout workout = new DilbarWorkout();
        workout.setTitle(request.getTitle());
        workout.setDescription(request.getDescription());
        workout.setScheduledAt(request.getScheduledAt());
        workout.setDurationMinutes(request.getDurationMinutes());
        return workout;
    }
}
