package com.hexaware.px.dao;
import com.hexaware.px.entity.Employee;
import java.util.List;

public interface IEmployeeService {
	Employee getEmployeeById(int employeeId);  // Retrieve employee by ID
    List<Employee> getAllEmployees();          // Get all employees
    boolean addEmployee(Employee employee);       // Add a new employee
    boolean updateEmployee(Employee employee);    // Update an existing employee's details
    boolean removeEmployee(int employeeId);       // Remove an employee by ID
}