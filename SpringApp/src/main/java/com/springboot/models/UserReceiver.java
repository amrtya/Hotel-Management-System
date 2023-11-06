package com.springboot.models;

public class UserReceiver {
	
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String mobileNo;
	private String jobRole;
	private String password; 

	
	public UserReceiver() {
		
	}
	
	public UserReceiver(String firstName, String lastName, String address, String emailId, String mobileNo,
			String jobRole, String password) {
		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = emailId;
		this.mobileNo = mobileNo;
		this.jobRole = jobRole;
		this.password = password;
	}
	
	public UserModel getCustomerModel() {
		return new UserModel(firstName, lastName, address, email, mobileNo, jobRole, password);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
