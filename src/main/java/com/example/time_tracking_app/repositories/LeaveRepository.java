package com.example.time_tracking_app.repositories;



import com.example.time_tracking_app.models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    // Дополнительные методы, если необходимо
}
