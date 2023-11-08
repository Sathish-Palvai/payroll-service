package com.example.payrollservice.binding;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlElement(name = "EmployeeID")
    private int employeeID;

    @XmlElement(name = "FirstName")
    private String firstName;

    @XmlElement(name = "LastName")
    private String lastName;

    @XmlElement(name = "SocialSecurityNumber")
    private String socialSecurityNumber;

    @XmlElement(name = "DateOfBirth")
    @XmlSchemaType(name = "date")
    private Date dateOfBirth;

    @XmlElement(name = "Position")
    private String position;

    @XmlElement(name = "DepartmentID")
    private String departmentID;

    @XmlElement(name = "HireDate")
    @XmlSchemaType(name = "date")
    private Date hireDate;

    @XmlElement(name = "Address")
    private String address;

    @XmlElement(name = "City")
    private String city;

    @XmlElement(name = "State")
    private String state;

    @XmlElement(name = "ZipCode")
    private String zipCode;

    @XmlElement(name = "ContactNumber")
    private String contactNumber;

    @XmlElement(name = "Email")
    private String email;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
                + ", socialSecurityNumber=" + socialSecurityNumber + ", dateOfBirth=" + dateOfBirth + ", position="
                + position + ", departmentID=" + departmentID + ", hireDate=" + hireDate + ", address=" + address
                + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", contactNumber=" + contactNumber
                + ", email=" + email + "]";
    }

    
    
}