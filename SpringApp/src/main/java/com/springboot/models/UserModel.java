package com.springboot.models;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class UserModel {
	
	public static String CUSTOMER = "CUSTOMER", EMPLOYEE = "EMPLOYEE", MANAGER = "MANAGER", ADMIN = "ADMIN";
	
	@Id 
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	private String userId;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String mobileNo;
	private String jobRole;
	
	@OneToMany(mappedBy = "customers")
	private List<ReservationModel> reservations;
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserModel(String firstName, String lastName, String address, String emailId,
			String mobileNo, String jobRole) {
		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = emailId;
		this.mobileNo = mobileNo;
		this.jobRole = jobRole;
	}
	
	public UserModel(String userId, String firstName, String lastName, String address, String emailId,
			String mobileNo, String jobRole) {
		
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = emailId;
		this.mobileNo = mobileNo;
		this.jobRole = jobRole;
	}

	public String getCustId() {
		return userId;
	}

	public void setCustId(String custId) {
		this.userId = custId;
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

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
}
