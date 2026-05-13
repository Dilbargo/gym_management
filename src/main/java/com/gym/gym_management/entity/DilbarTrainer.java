package com.gym.gym_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "trainers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DilbarTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String bio;

    @Column
    private String photoPath;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    private List<DilbarWorkout> workouts;
}
