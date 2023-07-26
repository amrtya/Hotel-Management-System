package com.springboot.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table
public class ReservationModel {
	
	private int noOfDays;
	private int noOfRooms; 

	@Column(precision = 2)
	private double amount; 
	private Date dateOfBook;
	private Boolean receiptGenerated;
	
	@Id
	private String userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usermodel_userid")
	private UserModel users;
	

	public ReservationModel() {
		super();
	}
	
	public ReservationModel(int noOfDays, int noOfRooms, double amount, Date dateOfBook, Boolean receiptGenerated,  
			UserModel users) {
		super();
		this.noOfDays = noOfDays;
		this.noOfRooms = noOfRooms;
		this.amount = amount;
		this.dateOfBook = dateOfBook;
		this.receiptGenerated = receiptGenerated;
		this.users = users;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateOfBook() {
		return dateOfBook;
	}

	public void setDateOfBook(Date dateOfBook) {
		this.dateOfBook = dateOfBook;
	}

	public Boolean getReceiptGenerated() {
		return receiptGenerated;
	}

	public void setReceiptGenerated(Boolean receiptGenerated) {
		this.receiptGenerated = receiptGenerated;
	}

	public UserModel getUsers() {
		return users;
	}

	public void setUsers(UserModel users) {
		this.users = users;
	}
}
