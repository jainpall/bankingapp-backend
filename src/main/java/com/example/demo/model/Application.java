package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	
	@Entity
	public class Application {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String email;
		private String loanType;
		private int roi;
		private int loanAmount;
		private int tenure;
		private int monthlyEmi;
		public Application() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Application(String email, String loanType, int roi, int loanAmount, int tenure, int monthlyEmi) {
			super();
			this.email = email;
			this.loanType = loanType;
			this.roi = roi;
			this.loanAmount = loanAmount;
			this.tenure = tenure;
			this.monthlyEmi = monthlyEmi;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
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
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Application [id=");
			builder.append(id);
			builder.append(", email=");
			builder.append(email);
			builder.append(", loanType=");
			builder.append(loanType);
			builder.append(", roi=");
			builder.append(roi);
			builder.append(", loanAmount=");
			builder.append(loanAmount);
			builder.append(", tenure=");
			builder.append(tenure);
			builder.append(", monthlyEmi=");
			builder.append(monthlyEmi);
			builder.append("]");
			return builder.toString();
		}
		@Override
		public int hashCode() {
			return Objects.hash(email, id, loanAmount, loanType, monthlyEmi, roi, tenure);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Application other = (Application) obj;
			return Objects.equals(email, other.email) && Objects.equals(id, other.id) && loanAmount == other.loanAmount
					&& Objects.equals(loanType, other.loanType) && monthlyEmi == other.monthlyEmi && roi == other.roi
					&& tenure == other.tenure;
		}
		
		
		
		
	}
		
	
	
	
		
		


