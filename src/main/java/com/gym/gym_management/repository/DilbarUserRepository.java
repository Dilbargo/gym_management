package com.gym.gym_management.repository;

import com.gym.gym_management.entity.DilbarUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DilbarUserRepository extends JpaRepository<DilbarUser, Long> {
    Optional<DilbarUser> findByUsername(String username);
    Optional<DilbarUser> findByEmail(String email);
    boolean existsByEmail(String email);
    Page<DilbarUser> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
}
