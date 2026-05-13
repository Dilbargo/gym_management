package com.gym.gym_management.repository;

import com.gym.gym_management.entity.DilbarSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DilbarSubscriptionRepository extends JpaRepository<DilbarSubscription, Long> {
    List<DilbarSubscription> findByUserId(Long userId);
    List<DilbarSubscription> findByPlan(String plan);
}

