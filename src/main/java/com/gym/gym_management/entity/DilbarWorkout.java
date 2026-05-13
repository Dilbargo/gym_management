package com.gym.gym_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "workouts")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DilbarWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime scheduledAt;

    @Column(nullable = false)
    private Integer durationMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private DilbarTrainer trainer;

    @ManyToMany
    @JoinTable(
            name = "workout_users",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<DilbarUser> participants;
}
