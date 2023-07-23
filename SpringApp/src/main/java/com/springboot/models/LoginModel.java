package com.springboot.models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class LoginModel {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	private String loginId;
	private String mobNo; 
	private String password;
	
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginModel(String mobNo, String password) {
		super();
		this.mobNo = mobNo;
		this.password = password;
	}

	public LoginModel(String loginId, String mobNo, String password) {
		super();
		this.loginId = loginId;
		this.mobNo = mobNo;
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
