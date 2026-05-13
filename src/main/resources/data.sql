-- Users
INSERT INTO users (username, email, password, role, created_at) VALUES
                                                                    ('admin', 'admin@gym.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'ADMIN', NOW()),
                                                                    ('john_doe', 'john@gym.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'USER', NOW()),
                                                                    ('jane_doe', 'jane@gym.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'USER', NOW()),
                                                                    ('trainer_bob', 'bob@gym.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'TRAINER', NOW())
ON CONFLICT DO NOTHING;

-- Trainers
INSERT INTO trainers (full_name, specialization, bio, created_at) VALUES
                                                                      ('Bob Smith', 'Yoga', 'Certified yoga instructor with 10 years experience', NOW()),
                                                                      ('Alice Johnson', 'CrossFit', 'Professional CrossFit coach and nutritionist', NOW()),
                                                                      ('Mike Brown', 'Boxing', 'Former professional boxer, now personal trainer', NOW())
ON CONFLICT DO NOTHING;

-- Subscriptions
INSERT INTO subscriptions (plan, start_date, end_date, price, user_id) VALUES
                                                                           ('MONTHLY', '2026-05-01', '2026-06-01', 49.99, 1),
                                                                           ('YEARLY', '2026-01-01', '2027-01-01', 399.99, 2),
                                                                           ('MONTHLY', '2026-05-01', '2026-06-01', 49.99, 3)
ON CONFLICT DO NOTHING;

-- Workouts
INSERT INTO workouts (title, description, scheduled_at, duration_minutes, trainer_id) VALUES
                                                                                          ('Morning Yoga', 'Relaxing morning yoga session for all levels', '2026-05-15 08:00:00', 60, 1),
                                                                                          ('CrossFit Basics', 'Introduction to CrossFit training', '2026-05-15 10:00:00', 90, 2),
                                                                                          ('Boxing Training', 'Basic boxing techniques and cardio', '2026-05-15 18:00:00', 75, 3)
ON CONFLICT DO NOTHING;

-- Schedules
INSERT INTO schedules (day_of_week, start_time, end_time, workout_id, trainer_id) VALUES
                                                                                      ('MONDAY', '08:00:00', '09:00:00', 1, 1),
                                                                                      ('WEDNESDAY', '08:00:00', '09:00:00', 1, 1),
                                                                                      ('TUESDAY', '10:00:00', '11:30:00', 2, 2),
                                                                                      ('THURSDAY', '18:00:00', '19:15:00', 3, 3)
ON CONFLICT DO NOTHING;
