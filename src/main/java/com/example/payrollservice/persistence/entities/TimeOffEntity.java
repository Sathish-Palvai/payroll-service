package com.example.payrollservice.persistence.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TimeOff")
public class TimeOffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timeOffId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private EmployeeEntity employee;
    private String timeOffType;
    private Date startDate;

    public Integer getTimeOffId() {
        return timeOffId;
    }

    public void setTimeOffId(Integer timeOffId) {
        this.timeOffId = timeOffId;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public String getTimeOffType() {
        return timeOffType;
    }

    public void setTimeOffType(String timeOffType) {
        this.timeOffType = timeOffType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}