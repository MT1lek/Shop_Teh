package com.example.time_tracking_app.service;


import com.example.time_tracking_app.models.Attendance;
import com.example.time_tracking_app.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
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

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    // Дополнительные функции, если необходимо
}
