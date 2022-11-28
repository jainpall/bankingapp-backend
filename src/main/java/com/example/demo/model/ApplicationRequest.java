package com.example.demo.model;

import lombok.Data;

@Data
public class ApplicationRequest {

	private String email;
	private String loanType;
	private int roi;
	private int loanAmount;
	private int tenure;
	private int monthlyEmi;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getRoi() {
		return roi;
	}
	public void setRoi(int roi) {
		this.roi = roi;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getMonthlyEmi() {
		return monthlyEmi;
	}
	public void setMonthlyEmi(int monthlyEmi) {
		this.monthlyEmi = monthlyEmi;
	}
	
}
