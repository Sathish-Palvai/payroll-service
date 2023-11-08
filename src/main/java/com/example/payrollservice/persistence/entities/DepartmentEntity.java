package com.example.payrollservice.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @Column(nullable = false, length = 255)
    private String departmentName;

    // Manager is also an employee, hence the Employee entity is reused
    @OneToOne
    @JoinColumn(name = "managerId", referencedColumnName = "employeeId")
    private EmployeeEntity manager;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

}
