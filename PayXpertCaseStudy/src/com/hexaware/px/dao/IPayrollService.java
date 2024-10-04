package com.hexaware.px.dao;
import com.hexaware.px.entity.Payroll;

import java.util.List;
import java.time.LocalDate;
public interface IPayrollService {
	void generatePayroll(int employeeId, String payPeriodStartDate, String payPeriodEndDate);  // Generate payroll for an employee
    Payroll getPayrollById(int payrollId);   // Retrieve payroll by ID
    List<Payroll> getPayrollsForEmployee(int employeeId);  // Get payrolls for a specific employee
    List<Payroll> getPayrollsForPeriod(String payPeriodStartDate, String payPeriodEndDate);  // Get payrolls for a time period
}