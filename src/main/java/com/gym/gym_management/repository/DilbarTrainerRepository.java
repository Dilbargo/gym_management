package com.gym.gym_management.repository;

import com.gym.gym_management.entity.DilbarTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DilbarTrainerRepository extends JpaRepository<DilbarTrainer, Long> {
    Optional<DilbarTrainer> findByFullName(String fullName);
    List<DilbarTrainer> findBySpecialization(String specialization);
}
