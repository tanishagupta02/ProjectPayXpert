package com.hexaware.px.entity;

public class Tax {
    private int taxID;
    private int employeeID;
    private int taxYear;
    private double taxableIncome;
    private double taxAmount;


    // Parameterized constructor
    public Tax(int taxID, int employeeID, int taxYear, double taxableIncome, double taxAmount) {
        this.taxID = taxID;
        this.employeeID = employeeID;
        this.taxYear = taxYear;
        this.taxableIncome = taxableIncome;
        this.taxAmount = taxAmount;
    }

    // Getters and Setters
	public int getTaxID() {
		return taxID;
	}

    // toString Method
	@Override
	public String toString() {
		return "Tax [taxID=" + taxID + ", employeeID=" + employeeID + ", taxYear=" + taxYear + ", taxableIncome="
				+ taxableIncome + ", taxAmount=" + taxAmount + "]";
	}

	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public int getTaxYear() {
		return taxYear;
	}


	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}


	public double getTaxableIncome() {
		return taxableIncome;
	}


	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}


	public double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
  
}

