package com.example.time_tracking_app.controller;

import com.example.time_tracking_app.models.UserCredentials;
import com.example.time_tracking_app.repositories.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-credentials")
public class UserCredentialsController {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @GetMapping("/{username}")
    public UserCredentials getUserCredentialsByUsername(@PathVariable String username) {
        return userCredentialsRepository.findById(username).orElse(null);
    }

    @PostMapping("/")
    public UserCredentials createUserCredentials(@RequestBody UserCredentials userCredentials) {
        return userCredentialsRepository.save(userCredentials);
    }

    @PutMapping("/{username}")
    public UserCredentials updateUserCredentials(@PathVariable String username, @RequestBody UserCredentials updatedUserCredentials) {
        UserCredentials existingUserCredentials = userCredentialsRepository.findById(username).orElse(null);
        if (existingUserCredentials != null) {
            existingUserCredentials.setPassword(updatedUserCredentials.getPassword());
            existingUserCredentials.setEmployee(updatedUserCredentials.getEmployee());
            return userCredentialsRepository.save(existingUserCredentials);
        }
        return null;
    }

    @DeleteMapping("/{username}")
    public void deleteUserCredentials(@PathVariable String username) {
        userCredentialsRepository.deleteById(username);
    }
}
