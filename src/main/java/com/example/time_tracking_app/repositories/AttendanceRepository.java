package com.example.time_tracking_app.repositories;

import com.example.time_tracking_app.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Дополнительные методы, если необходимо
}
