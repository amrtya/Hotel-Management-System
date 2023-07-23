package com.springboot.models;

public class CustomerReceiver {
	
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String mobileNo;
	private String pwd;

	
	public CustomerReceiver() {
		
	}
	
	public CustomerReceiver(String firstName, String lastName, String address, String emailId, String mobileNo,
			String pwd) {
		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = emailId;
		this.mobileNo = mobileNo;
		this.pwd = pwd;
	}
	
	public CustomerModel getCustomerModel() {
		return new CustomerModel(firstName, lastName, address, email, mobileNo);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return email;
	}

	public void setEmailId(String emailId) {
		this.email = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
