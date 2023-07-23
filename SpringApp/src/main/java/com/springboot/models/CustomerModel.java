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
public class CustomerModel {
	
	@Id 
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	private String custId;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String mobileNo;
	
	@OneToMany(mappedBy = "customers")
	private List<ReservationModel> reservations;
	
	public CustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerModel(String firstName, String lastName, String address, String emailId,
			String mobileNo) {
		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = emailId;
		this.mobileNo = mobileNo;
	}
	
	public CustomerModel(String custId, String firstName, String lastName, String address, String emailId,
			String mobileNo) {
		
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = emailId;
		this.mobileNo = mobileNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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
	
	
	
}
