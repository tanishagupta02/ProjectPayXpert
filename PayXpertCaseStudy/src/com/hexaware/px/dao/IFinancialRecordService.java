package com.hexaware.px.dao;
import com.hexaware.px.entity.FinancialRecord;
import java.util.List;


public interface IFinancialRecordService {
	boolean addFinancialRecord(FinancialRecord record);  // Add a financial record
    FinancialRecord getFinancialRecordById(int recordId);  // Get a financial record by ID
    List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId);  // Get all financial records for an employee
    List<FinancialRecord> getFinancialRecordsForDate(String recordDate);  // Get financial records for a specific date

}
