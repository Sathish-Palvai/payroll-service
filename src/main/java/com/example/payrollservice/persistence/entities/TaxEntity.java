package com.example.payrollservice.persistence.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Taxes")
public class TaxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taxId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private EmployeeEntity employee;
    private BigDecimal federalIncomeTax;
    private BigDecimal stateIncomeTax;
    private BigDecimal socialSecurityTax;
    private BigDecimal medicareTax;

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public BigDecimal getFederalIncomeTax() {
        return federalIncomeTax;
    }

    public void setFederalIncomeTax(BigDecimal federalIncomeTax) {
        this.federalIncomeTax = federalIncomeTax;
    }

    public BigDecimal getStateIncomeTax() {
        return stateIncomeTax;
    }

    public void setStateIncomeTax(BigDecimal stateIncomeTax) {
        this.stateIncomeTax = stateIncomeTax;
    }

    public BigDecimal getSocialSecurityTax() {
        return socialSecurityTax;
    }

    public void setSocialSecurityTax(BigDecimal socialSecurityTax) {
        this.socialSecurityTax = socialSecurityTax;
    }

    public BigDecimal getMedicareTax() {
        return medicareTax;
    }

    public void setMedicareTax(BigDecimal medicareTax) {
        this.medicareTax = medicareTax;
    }

}
