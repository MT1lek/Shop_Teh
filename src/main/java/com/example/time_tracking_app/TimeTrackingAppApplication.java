package com.example.time_tracking_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TimeTrackingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeTrackingAppApplication.class, args);
    }

}
