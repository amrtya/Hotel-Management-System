package com.springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerModel {
	

	@Id
	private String custId;
	private String firstName;
	private String lastName;
	private String address;
	private String emailId;
	private String mobileNo;
	private String pwd;
	
	public CustomerModel() {
		
	}
	
	public CustomerModel(String custId, String firstName, String lastName, String address, String emailId, String mobileNo,
			String pwd) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.pwd = pwd;
	}

	public String getCustId() {
		return custId;
	}

	public String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	protected void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	protected void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	protected String getPwd() {
		return pwd;
	}

	protected void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
