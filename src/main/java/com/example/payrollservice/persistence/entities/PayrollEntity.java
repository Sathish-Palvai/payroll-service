package com.example.payrollservice.persistence.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Payroll")
public class PayrollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollId;

    @ManyToOne
    @JoinColumn(name = "employeeId", nullable = false)
    private EmployeeEntity employee;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date payPeriodStartDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date payPeriodEndDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal hoursWorked;

    @Column(precision = 10, scale = 2)
    private BigDecimal regularPay;

    @Column(precision = 10, scale = 2)
    private BigDecimal overtimePay;

    @Column(precision = 10, scale = 2)
    private BigDecimal grossPay;

    @Column(precision = 10, scale = 2)
    private BigDecimal netPay;

    // Standard getters and setters
    // ...
}
