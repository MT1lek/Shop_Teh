package com.example.time_tracking_app.repositories;

import com.example.time_tracking_app.models.WorkHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {
    // Дополнительные методы, если необходимо
}
