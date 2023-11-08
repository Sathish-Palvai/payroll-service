package com.example.payrollservice.binding;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Payroll {

    @XmlAttribute(name = "type")
    private String type;

    @XmlElement(name = "PayrollID")
    private String payrollID;

    @XmlElement(name = "EmployeeID")
    private String employeeID;

    @XmlElement(name = "PayPeriodStartDate")
    @XmlSchemaType(name = "date")
    private Date payPeriodStartDate;

    @XmlElement(name = "PayPeriodEndDate")
    @XmlSchemaType(name = "date")
    private Date payPeriodEndDate;

    @XmlElement(name = "HoursWorked")
    private double hoursWorked;

    @XmlElement(name = "RegularPay")
    private double regularPay;

    @XmlElement(name = "OvertimePay")
    private double overtimePay;

    @XmlElement(name = "GrossPay")
    private double grossPay;

    @XmlElement(name = "NetPay")
    private double netPay;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(String payrollID) {
        this.payrollID = payrollID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Date getPayPeriodStartDate() {
        return payPeriodStartDate;
    }

    public void setPayPeriodStartDate(Date payPeriodStartDate) {
        this.payPeriodStartDate = payPeriodStartDate;
    }

    public Date getPayPeriodEndDate() {
        return payPeriodEndDate;
    }

    public void setPayPeriodEndDate(Date payPeriodEndDate) {
        this.payPeriodEndDate = payPeriodEndDate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRegularPay() {
        return regularPay;
    }

    public void setRegularPay(double regularPay) {
        this.regularPay = regularPay;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    @Override
    public String toString() {
        return "Payroll [type=" + type + ", payrollID=" + payrollID + ", employeeID=" + employeeID
                + ", payPeriodStartDate=" + payPeriodStartDate + ", payPeriodEndDate=" + payPeriodEndDate
                + ", hoursWorked=" + hoursWorked + ", regularPay=" + regularPay + ", overtimePay=" + overtimePay
                + ", grossPay=" + grossPay + ", netPay=" + netPay + "]";
    }

    

}