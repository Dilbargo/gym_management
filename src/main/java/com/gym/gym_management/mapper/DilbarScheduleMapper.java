package com.gym.gym_management.mapper;

import com.gym.gym_management.dto.request.DilbarScheduleRequest;
import com.gym.gym_management.dto.response.DilbarScheduleResponse;
import com.gym.gym_management.entity.DilbarSchedule;
import org.springframework.stereotype.Component;

@Component
public class DilbarScheduleMapper {
    public DilbarScheduleResponse toResponse(DilbarSchedule schedule) {
        DilbarScheduleResponse response = new DilbarScheduleResponse();
        response.setId(schedule.getId());
        response.setDayOfWeek(schedule.getDayOfWeek());
        response.setStartTime(schedule.getStartTime());
        response.setEndTime(schedule.getEndTime());
        response.setWorkoutTitle(schedule.getWorkout().getTitle());
        response.setTrainerName(schedule.getTrainer().getFullName());
        return response;
    }
    public DilbarSchedule toEntity(DilbarScheduleRequest request) {
        DilbarSchedule schedule = new DilbarSchedule();
        schedule.setDayOfWeek(request.getDayOfWeek());
        schedule.setStartTime(request.getStartTime());
        schedule.setEndTime(request.getEndTime());
        return schedule;
    }
}
