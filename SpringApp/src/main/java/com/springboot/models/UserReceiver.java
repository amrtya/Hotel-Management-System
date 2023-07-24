package com.springboot.models;

public class UserReceiver {
	
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String mobileNo;
	private String pwd;
	private String jobRole;

	
	public UserReceiver() {
		
	}
	
	public UserReceiver(String firstName, String lastName, String address, String emailId, String mobileNo,
			String pwd, String jobRole) {
		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = emailId;
		this.mobileNo = mobileNo;
		this.pwd = pwd;
		this.jobRole = jobRole;
	}
	
	public UserModel getCustomerModel() {
		return new UserModel(firstName, lastName, address, email, mobileNo, jobRole);
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
	
}
