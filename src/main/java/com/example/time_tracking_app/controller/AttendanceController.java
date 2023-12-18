package com.example.time_tracking_app.controller;

import com.example.time_tracking_app.models.Attendance;
import com.example.time_tracking_app.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping("/")
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance updatedAttendance) {
        Attendance existingAttendance = attendanceRepository.findById(id).orElse(null);
        if (existingAttendance != null) {
            existingAttendance.setEmployee(updatedAttendance.getEmployee());
            existingAttendance.setDate(updatedAttendance.getDate());
            existingAttendance.setCheckInTime(updatedAttendance.getCheckInTime());
            existingAttendance.setCheckOutTime(updatedAttendance.getCheckOutTime());
            return attendanceRepository.save(existingAttendance);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceRepository.deleteById(id);
    }
}
