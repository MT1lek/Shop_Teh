//package com.example.time_tracking_app.controller;
//
//import com.example.time_tracking_app.models.UserCredentials;
//import com.example.time_tracking_app.repositories.UserCredentialsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private UserCredentialsRepository userCredentialsRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @PostMapping("/createAdmin")
//    public UserCredentials createAdmin(@RequestBody UserCredentials adminCredentials) {
//
//        // Хешируем пароль перед сохранением
//        adminCredentials.setPassword(passwordEncoder.encode(adminCredentials.getPassword()));
//
//        // Присваиваем роль администратора
//        adminCredentials.setRole("ROLE_ADMIN");
//        return userCredentialsRepository.save(adminCredentials);
//    }
//}


