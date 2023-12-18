package com.example.time_tracking_app.controller;


import com.example.time_tracking_app.models.WorkHours;
import com.example.time_tracking_app.repositories.WorkHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work-hours")
public class WorkHoursController {

    @Autowired
    private WorkHoursRepository workHoursRepository;

    @GetMapping("/")
    public List<WorkHours> getAllWorkHours() {
        return workHoursRepository.findAll();
    }

    @GetMapping("/{id}")
    public WorkHours getWorkHoursById(@PathVariable Long id) {
        return workHoursRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public WorkHours createWorkHours(@RequestBody WorkHours workHours) {
        return workHoursRepository.save(workHours);
    }

    @PutMapping("/{id}")
    public WorkHours updateWorkHours(@PathVariable Long id, @RequestBody WorkHours updatedWorkHours) {
        WorkHours existingWorkHours = workHoursRepository.findById(id).orElse(null);
        if (existingWorkHours != null) {
            existingWorkHours.setEmployee(updatedWorkHours.getEmployee());
            existingWorkHours.setDate(updatedWorkHours.getDate());
            existingWorkHours.setHoursWorked(updatedWorkHours.getHoursWorked());
            return workHoursRepository.save(existingWorkHours);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteWorkHours(@PathVariable Long id) {
        workHoursRepository.deleteById(id);
    }
}
