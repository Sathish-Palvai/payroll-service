-- Department Table
CREATE TABLE Departments (
    DepartmentID SERIAL PRIMARY KEY,
    DepartmentName VARCHAR(255) NOT NULL,
    ManagerID INT REFERENCES Employees(EmployeeID)
);

-- Employee Table
CREATE TABLE Employees (
    EmployeeID SERIAL PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    SocialSecurityNumber CHAR(11),
    DateOfBirth DATE NOT NULL,
    Position VARCHAR(255),
    DepartmentID INT REFERENCES Departments(DepartmentID),
    HireDate DATE NOT NULL,
    Address VARCHAR(255),
    City VARCHAR(255),
    State CHAR(2),
    ZipCode VARCHAR(10),
    ContactNumber VARCHAR(15),
    Email VARCHAR(255)
);

-- Payroll Table
CREATE TABLE Payroll (
    PayrollID SERIAL PRIMARY KEY,
    EmployeeID INT REFERENCES Employees(EmployeeID),
    PayPeriodStartDate DATE NOT NULL,
    PayPeriodEndDate DATE NOT NULL,
    HoursWorked NUMERIC(10,2),
    RegularPay NUMERIC(10,2),
    OvertimePay NUMERIC(10,2),
    GrossPay NUMERIC(10,2),
    NetPay NUMERIC(10,2)
);

-- Salary Table
CREATE TABLE Salary (
    EmployeeID INT PRIMARY KEY REFERENCES Employees(EmployeeID),
    AnnualSalary NUMERIC(10,2),
    PayRate NUMERIC(10,2),
    IsExempt BOOLEAN
);

-- Deductions Table
CREATE TABLE Deductions (
    DeductionID SERIAL PRIMARY KEY,
    EmployeeID INT REFERENCES Employees(EmployeeID),
    DeductionType VARCHAR(255) NOT NULL,
    DeductionAmount NUMERIC(10,2) NOT NULL,
    Description TEXT
);

-- Taxes Table
CREATE TABLE Taxes (
    TaxID SERIAL PRIMARY KEY,
    EmployeeID INT REFERENCES Employees(EmployeeID),
    FederalIncomeTax NUMERIC(10,2),
    StateIncomeTax NUMERIC(10,2),
    SocialSecurityTax NUMERIC(10,2),
    MedicareTax NUMERIC(10,2)
);

-- Benefits Table
CREATE TABLE Benefits (
    BenefitID SERIAL PRIMARY KEY,
    EmployeeID INT REFERENCES Employees(EmployeeID),
    BenefitType VARCHAR(255) NOT NULL,
    EmployeeContribution NUMERIC(10,2),
    EmployerContribution NUMERIC(10,2)
);

-- Time Off Table
CREATE TABLE TimeOff (
    TimeOffID SERIAL PRIMARY KEY,
    EmployeeID INT REFERENCES Employees(EmployeeID),
    TimeOffType VARCHAR(255) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE,
    Hours INT
);

-- Payroll History Table
CREATE TABLE PayrollHistory (
    HistoryID SERIAL PRIMARY KEY,
    PayrollID INT REFERENCES Payroll(PayrollID),
    EmployeeID INT REFERENCES Employees(EmployeeID),
    PayDate DATE NOT NULL,
    PayPeriod VARCHAR(255) NOT NULL,
    AmountPaid NUMERIC(10,2)
);
