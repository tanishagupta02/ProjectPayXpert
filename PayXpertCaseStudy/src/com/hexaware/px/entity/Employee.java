package com.hexaware.px.entity;

public class Employee {
	
      private int employeeId;
      private String firstName;
      private String lastName;
      private String dob;
      private String gender;
      private String email;
      private String phoneNo;
      private String address;
      private String position;
      private String joiningDate;
      private String terminationDate;
      
      // Parameterized constructor
      public Employee(int employeeId, String firstName, String lastName, String dob, String gennder, String email,
  			String phoneNo, String address, String position, String joiningDate, String terminationDate) {
  		
  		this.employeeId = employeeId;
  		this.firstName = firstName;
  		this.lastName = lastName;
  		this.dob = dob;
  		this.gender = gennder;
  		this.email = email;
  		this.phoneNo = phoneNo;
  		this.address = address;
  		this.position = position;
  		this.joiningDate = joiningDate;
  		this.terminationDate = terminationDate;
  	}
     
    //toString Method 
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", gender=" + gender + ", email=" + email + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", position=" + position + ", joiningDate=" + joiningDate + ", terminationDate=" + terminationDate
				+ "]";
	}
	
	// Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}
	
      
      
}
