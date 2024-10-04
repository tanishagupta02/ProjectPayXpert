package com.hexaware.px.dao;
import com.hexaware.px.entity.Tax;
import java.util.List;
public interface ITaxService {
	 double calculateTax(int employeeId, int taxYear);  // Calculate tax for an employee
	    Tax getTaxById(int taxId);   // Retrieve tax record by ID
	    List<Tax> getTaxesForEmployee(int employeeId);  // Get tax records for an employee
	    List<Tax> getTaxesForYear(int taxYear);  // Get tax records for a specific year
	
}