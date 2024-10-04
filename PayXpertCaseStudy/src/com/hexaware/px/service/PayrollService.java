package com.hexaware.px.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.px.dao.IPayrollService;
import com.hexaware.px.entity.Payroll;

public class PayrollService implements IPayrollService {
	
private Connection connection = null;
	
	public PayrollService() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PayXpert","root","Tanisha@123");
		
	}

	@Override
	public void generatePayroll(int employeeId, String payPeriodStartDate, String payPeriodEndDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payroll getPayrollById(int payrollId) {
		// TODO Auto-generated method stub
		String query = " Select * from Payroll";
        Payroll ans = null;
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{
			
			int id = rs.getInt("payrollId");
			if(id == payrollId) {
			    int empId = rs.getInt("employeeId");
				String startDate = rs.getString("payPeriodStartDate");
				String endDate = rs.getString("payPeriodEndDate");
			    Double bs = rs.getDouble("basicSalary");
			    Double otp = rs.getDouble("overtimePay");
				Double deduc = rs.getDouble("deductions");
				Double ns = rs.getDouble("netSalary");
		
				
				ans = new Payroll(id,empId,startDate,endDate,bs,otp,deduc,ns);
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
	public List<Payroll> getPayrollsForEmployee(int employeeId) {
		// TODO Auto-generated method stub
		String query = " Select * from Payroll";
		List<Payroll> ans = new ArrayList<>();
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{
				    int id = rs.getInt("payrollId");
				    int empId = rs.getInt("employeeId");
					String startDate = rs.getString("payPeriodStartDate");
					String endDate = rs.getString("payPeriodEndDate");
				    Double bs = rs.getDouble("basicSalary");
				    Double otp = rs.getDouble("overtimePay");
					Double deduc = rs.getDouble("deductions");
					Double ns = rs.getDouble("netSalary");
			
				
				ans.add(new Payroll(id,empId,startDate,endDate,bs,otp,deduc,ns));
				
			
			
		}
			
		 
		}
		catch(SQLException e)
		{e.printStackTrace();
			}
		return ans;
	}

	@Override
	public List<Payroll> getPayrollsForPeriod(String payPeriodStartDate, String payPeriodEndDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
