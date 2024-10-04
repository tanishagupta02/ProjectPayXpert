package com.hexaware.px.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.px.dao.IEmployeeService;
import com.hexaware.px.entity.Employee;

public class EmployeeService implements IEmployeeService {
	
	private Connection connection = null;
	
	public EmployeeService() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PayXpert","root","Tanisha@123");
		
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		
        String query = " Select * from Employee";
        Employee ans = null;
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{
			
			int id = rs.getInt("employeeId");
			if(id == employeeId) {
				String fn = rs.getString("firstName");
				String ln = rs.getString("lastName");
				String dob = rs.getString("dateOfBirth");
				String g = rs.getString("gender");
				String e = rs.getString("email");
				String phn = rs.getString("phoneNumber");
				String ad = rs.getString("address");
				String pos = rs.getString("position");
				String jd = rs.getString("joiningDate");
				String td = rs.getString("terminationDate");
				
				ans = new Employee(id,fn,ln,dob,g,e,phn,ad,pos,jd,td);
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
	public List<Employee> getAllEmployees() {
		String query = " Select * from Employee";
		List<Employee> ans = new ArrayList<>();
		
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		    ResultSet rs = 	ps.executeQuery();
		    
		 while(rs.next())
		{
			
			int id = rs.getInt("employeeId");
			
				String fn = rs.getString("firstName");
				String ln = rs.getString("lastName");
				String dob = rs.getString("dateOfBirth");
				String g = rs.getString("gender");
				String e = rs.getString("email");
				String phn = rs.getString("phoneNumber");
				String ad = rs.getString("address");
				String pos = rs.getString("position");
				String jd = rs.getString("joiningDate");
				String td = rs.getString("terminationDate");
				
				ans.add(new Employee(id,fn,ln,dob,g,e,phn,ad,pos,jd,td));
				
			
			
		}
			
		 
		}
		catch(SQLException e)
		{e.printStackTrace();
			}
		return ans;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		String query = "INSERT INTO employee(employeeId,firstName,lastName,dateOfBirth,gender,email,phoneNumber,address,position,joiningDate,terminationDate) values (?,?,?,?,?,?,?,?,?,?,?)";
		{
			//DAO Pattern 
			try
			{
				
				PreparedStatement ps  = connection.prepareStatement(query);
								
				ps.setInt(1, emp.getEmployeeId());
				ps.setString(2, emp.getFirstName());
				ps.setString(3, emp.getLastName());
				ps.setString(4, emp.getDob());
				ps.setString(5, emp.getGender());
				ps.setString(6, emp.getEmail());
				ps.setString(7, emp.getPhoneNo());
				ps.setString(8, emp.getAddress());
				ps.setString(9, emp.getPosition());
				ps.setString(10, emp.getJoiningDate());
				ps.setString(11, emp.getTerminationDate());
				
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
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return true;
		
	}

	@Override
	public boolean removeEmployee(int employeeId) {
		
		String query = "Delete from Employee where EmployeeId= "+ employeeId;
        int rs = 0;
		try
		{
			
			PreparedStatement ps  = connection.prepareStatement(query);
							
		     rs = 	ps.executeUpdate();
		       
		  
		}
		catch(SQLException e)
		{e.printStackTrace();
			}
		return rs>0;
	}

}
