package com.example.time_tracking_app.models;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "work_hours")
public class WorkHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_hours_id")
    private Long workHoursId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "date")
    private Date date;

    @Column(name = "hours_worked")
    private int hoursWorked;

    public WorkHours() {
    }

    public WorkHours(Employee employee, Date date, int hoursWorked) {
        this.employee = employee;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

    public Long getWorkHoursId() {
        return workHoursId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
