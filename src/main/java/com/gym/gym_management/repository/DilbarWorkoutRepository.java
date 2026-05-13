package com.gym.gym_management.repository;

import com.gym.gym_management.entity.DilbarWorkout;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DilbarWorkoutRepository extends JpaRepository<DilbarWorkout, Long> {
    List<DilbarWorkout> findByTrainerId(Long trainerId);
    Page<DilbarWorkout> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
