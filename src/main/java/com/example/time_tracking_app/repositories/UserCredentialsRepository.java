package com.example.time_tracking_app.repositories;


import com.example.time_tracking_app.models.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, String> {
    // Дополнительные методы, если необходимо
}
