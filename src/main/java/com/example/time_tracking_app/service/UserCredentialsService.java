package com.example.time_tracking_app.service;


import com.example.time_tracking_app.models.UserCredentials;
import com.example.time_tracking_app.repositories.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    public UserCredentials getUserCredentialsByUsername(String username) {
        return userCredentialsRepository.findById(username).orElse(null);
    }

    public UserCredentials createUserCredentials(UserCredentials userCredentials) {
        return userCredentialsRepository.save(userCredentials);
    }

    public UserCredentials updateUserCredentials(String username, UserCredentials updatedUserCredentials) {
        UserCredentials existingUserCredentials = userCredentialsRepository.findById(username).orElse(null);
        if (existingUserCredentials != null) {
            existingUserCredentials.setPassword(updatedUserCredentials.getPassword());
            existingUserCredentials.setEmployee(updatedUserCredentials.getEmployee());
            return userCredentialsRepository.save(existingUserCredentials);
        }
        return null;
    }

    public void deleteUserCredentials(String username) {
        userCredentialsRepository.deleteById(username);
    }

    // Дополнительные функции, если необходимо
}
