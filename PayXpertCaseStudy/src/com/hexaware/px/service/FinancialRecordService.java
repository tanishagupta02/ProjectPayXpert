package com.hexaware.px.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.px.dao.IFinancialRecordService;
import com.hexaware.px.entity.FinancialRecord;

public class FinancialRecordService implements IFinancialRecordService{
	
private Connection connection = null;
	
	public FinancialRecordService() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PayXpert","root","Tanisha@123");
		
	}

	@Override
	public boolean addFinancialRecord(FinancialRecord record) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO financialRecord(recordId,employeeId,recordDate,description,amount,recordType)values(?,?,?,?,?,?)";
		{
			//DAO Pattern 
			try
			{
				
				PreparedStatement ps  = connection.prepareStatement(query);
								
				ps.setInt(1, record.getRecordID());
				ps.setInt(2, record.getEmployeeID());
				ps.setString(3, record.getRecordDate());
				ps.setString(4, record.getDescription());
				ps.setDouble(5, record.getAmount());
				ps.setString(6, record.getRecordType());
			
				
			  int i =	ps.executeUpdate();
			  System.out.println("Rows are added");
				return i>0;
			}
			catch(SQLException e)
			{e.printStackTrace();
				}
		}
		return false;
	}

	@Override
	public FinancialRecord getFinancialRecordById(int recordId) {
		// TODO Auto-generated method stub
		
		 String query = " Select * from FinancialRecord";
	        FinancialRecord ans = null;
			
			try
			{
				
				PreparedStatement ps  = connection.prepareStatement(query);
								
			    ResultSet rs = 	ps.executeQuery();
			    
			 while(rs.next())
			{
				
				int id = rs.getInt("recordId");
				if(id == recordId) {
					int empId = rs.getInt("employeeId");
					String rd = rs.getString("recordDate");
					String desc = rs.getString("description");
			        Double amt = rs.getDouble("amount");
					String rt = rs.getString("recordType");
	
					
					ans = new FinancialRecord(id,empId,rd,desc,amt,rt);
					break;
				}
				
			}
				
			 
			}
			catch(SQLException e)
			{e.printStackTrace();
				}
			return ans;
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId) {
		// TODO Auto-generated method stub
		String query = " Select * from FinancialRecord";
		List<FinancialRecord> ans = new ArrayList<>();
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{
			
			int id = rs.getInt("recordId");
			int empId = rs.getInt("employeeId");
			String rd = rs.getString("recordDate");
			String desc = rs.getString("description");
	        Double amt = rs.getDouble("amount");
			String rt = rs.getString("recordType");
			
				
				ans.add(new FinancialRecord(id,empId,rd,desc,amt,rt));
				
			
			
		}
			
		 
		}
		catch(SQLException e)
		{e.printStackTrace();
			}
		return ans;
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForDate(String recordDate) {
		String query = " Select * from FinancialRecord";
		List<FinancialRecord> ans = new ArrayList<>();
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{
			
			int id = rs.getInt("recordId");
			int empId = rs.getInt("employeeId");
			String rd = rs.getString("recordDate");
			String desc = rs.getString("description");
	        Double amt = rs.getDouble("amount");
			String rt = rs.getString("recordType");
			
				
				ans.add(new FinancialRecord(id,empId,rd,desc,amt,rt));
				
			
			
		}
			
		 
		}
		catch(SQLException e)
		{e.printStackTrace();
			}
		return ans;
	}

}
