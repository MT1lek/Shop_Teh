package com.example.time_tracking_app.controller;


import com.example.time_tracking_app.models.Leave;
import com.example.time_tracking_app.repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepository;

    @GetMapping("/")
    public List<Leave> getAllLeave() {
        return leaveRepository.findAll();
    }

    @GetMapping("/{id}")
    public Leave getLeaveById(@PathVariable Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Leave createLeave(@RequestBody Leave leave) {
        return leaveRepository.save(leave);
    }

    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable Long id, @RequestBody Leave updatedLeave) {
        Leave existingLeave = leaveRepository.findById(id).orElse(null);
        if (existingLeave != null) {
            existingLeave.setEmployee(updatedLeave.getEmployee());
            existingLeave.setLeaveType(updatedLeave.getLeaveType());
            existingLeave.setStartDate(updatedLeave.getStartDate());
            existingLeave.setEndDate(updatedLeave.getEndDate());
            return leaveRepository.save(existingLeave);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Long id) {
        leaveRepository.deleteById(id);
    }
}
