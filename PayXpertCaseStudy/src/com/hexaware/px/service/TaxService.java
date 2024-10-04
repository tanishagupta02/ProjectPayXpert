package com.hexaware.px.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.px.dao.ITaxService;
import com.hexaware.px.entity.Tax;

public class TaxService implements ITaxService {
	
private Connection connection = null;
	
	public TaxService() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PayXpert","root","Tanisha@123");
		
	}

	@Override
	public double calculateTax(int employeeId, int taxYear) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tax getTaxById(int taxId) {
		// TODO Auto-generated method stub
		String query = " Select * from Tax";
        Tax ans = null;
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{
			
			int id = rs.getInt("taxId");
			if(id == taxId) {
				int empId = rs.getInt("employeeId");
				int year = rs.getInt("taxYear");
				Double ti = rs.getDouble("taxableIncome");
				Double ta = rs.getDouble("taxAmount");
	
				
				ans = new Tax(id,empId,year,ti,ta);
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
	public List<Tax> getTaxesForEmployee(int employeeId) {
		// TODO Auto-generated method stub
		String query = " Select * from Tax";
		List<Tax> ans = new ArrayList<>();
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{

				    int id = rs.getInt("taxId");
					int empId = rs.getInt("employeeId");
					int year = rs.getInt("taxYear");
					Double ti = rs.getDouble("taxableIncome");
					Double ta = rs.getDouble("taxAmount");
			
				
				ans.add(new Tax(id,empId,year,ti,ta));
				
			
			
		}
			
		 
		}
		catch(SQLException e)
		{e.printStackTrace();
			}
		return ans;
	}

	@Override
	public List<Tax> getTaxesForYear(int taxYear) {
		// TODO Auto-generated method stub
		String query = " Select * from Tax";
		List<Tax> ans = new ArrayList<>();
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{

				    int id = rs.getInt("taxId");
					int empId = rs.getInt("employeeId");
					int year = rs.getInt("taxYear");
					Double ti = rs.getDouble("taxableIncome");
					Double ta = rs.getDouble("taxAmount");
			
				
				ans.add(new Tax(id,empId,year,ti,ta));
				
			
			
		}
			
		 
		}
		catch(SQLException e)
		{e.printStackTrace();
			}
		return ans;
	}

}
