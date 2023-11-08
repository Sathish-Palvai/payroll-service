package com.example.payrollservice.binding;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;


import java.util.List;

@XmlRootElement(name = "CompanyData")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyData {

    @XmlElementWrapper(name = "Employees")
    @XmlElement(name = "Employee")
    private List<Employee> employees;

    @XmlElementWrapper(name = "Payrolls")
    @XmlElement(name = "Payroll")
    private List<Payroll> payrolls;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Payroll> getPayrolls() {
        return payrolls;
    }

    public void setPayrolls(List<Payroll> payrolls) {
        this.payrolls = payrolls;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CompanyData{");

        sb.append("Employees=[");
        if (employees != null) {
            for (Employee employee : employees) {
                sb.append("\n    ").append(employee.toString());
            }
        }
        sb.append("\n]");

        sb.append(", Payrolls=[");
        if (payrolls != null) {
            for (Payroll payroll : payrolls) {
                sb.append("\n    ").append(payroll.toString());
            }
        }
        sb.append("\n]");

        sb.append('}');
        return sb.toString();
    }

}
