package com.gym.gym_management.repository;

import com.gym.gym_management.entity.DilbarSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DilbarScheduleRepository extends JpaRepository<DilbarSchedule, Long> {
    List<DilbarSchedule> findByDayOfWeek(String dayOfWeek);
    List<DilbarSchedule> findByTrainerId(Long trainerId);
}
