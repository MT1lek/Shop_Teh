package com.example.time_tracking_app.service;


import com.example.time_tracking_app.models.WorkHours;
import com.example.time_tracking_app.repositories.WorkHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkHoursService {

    @Autowired
    private WorkHoursRepository workHoursRepository;

    public List<WorkHours> getAllWorkHours() {
        return workHoursRepository.findAll();
    }

    public WorkHours getWorkHoursById(Long id) {
        return workHoursRepository.findById(id).orElse(null);
    }

    public WorkHours createWorkHours(WorkHours workHours) {
        return workHoursRepository.save(workHours);
    }

    public WorkHours updateWorkHours(Long id, WorkHours updatedWorkHours) {
        WorkHours existingWorkHours = workHoursRepository.findById(id).orElse(null);
        if (existingWorkHours != null) {
            existingWorkHours.setEmployee(updatedWorkHours.getEmployee());
            existingWorkHours.setDate(updatedWorkHours.getDate());
            existingWorkHours.setHoursWorked(updatedWorkHours.getHoursWorked());
            return workHoursRepository.save(existingWorkHours);
        }
        return null;
    }

    public void deleteWorkHours(Long id) {
        workHoursRepository.deleteById(id);
    }

    // Дополнительные функции, если необходимо
}
