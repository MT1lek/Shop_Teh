package com.example.time_tracking_app.repositories;

import com.example.time_tracking_app.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Дополнительные методы, если необходимо
}
