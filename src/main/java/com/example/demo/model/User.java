package com.example.demo.model;

import javax.persistence.Id;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;



@Entity
public class User {
	@Id
	private String email;
	private String name;
    private String dob;
    private String address;
	private String mobile;
	private String pancard;
	private Integer creditrating;
	private Integer monthlyincome;
	private String password;
	
	
	
	public User() {
		super();
		
	}
	
	public User(String email, String name, String dob, String address, String mobile, String pancard,Integer creditrating,Integer monthlyincome, String password) {
		super();
		this.email = email;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.mobile = mobile;
		this.pancard = pancard;
		this.creditrating = creditrating;
		this.monthlyincome= monthlyincome;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	
	public Integer getCreditrating() {
		return creditrating;
	}
	
	public void setCreditrating(int creditrating) {
		this.creditrating = creditrating;
	}
	
	public Integer getMonthlyincome() {
		return monthlyincome;
	}
	
	public void setMonthlyincome(int monthlyincome) {
		this.monthlyincome = monthlyincome;
	}
		
	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		
		 BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder(); 
		 String encryptedPwd = pwdEncoder.encode(password);
		 
        this.password = encryptedPwd;
	}


	
	
	@Override
	public int hashCode() {
		return Objects.hash(email, name, dob, address,mobile,pancard,creditrating,monthlyincome,password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(dob, other.dob) && Objects.equals(address, other.address) 
				&& Objects.equals(mobile, other.mobile) && Objects.equals(pancard, other.pancard)				
				&& Objects.equals(creditrating, other.creditrating) && Objects.equals(monthlyincome, other.monthlyincome)
				&& Objects.equals(password, other.password);
	}
}
	
	
	

	
	
	
	
	