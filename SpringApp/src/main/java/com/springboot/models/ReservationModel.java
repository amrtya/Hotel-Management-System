package com.springboot.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table
public class ReservationModel {
	
	@Column(nullable = false)
	private int noOfDays;
	
	@Column(nullable = false)
	private int noOfRooms; 
	
	@Column(nullable = false, precision = 2)
	private double amount; 
	
	@Column(nullable = false)
	private Date dateOfBook;
	
	@Column(nullable = false)
	private Boolean receiptGenerated;
	
	@Id
	private String custId;
	
	@ManyToOne
	private CustomerModel customers;
	

	public ReservationModel() {
		super();
	}
	
	public ReservationModel(int noOfDays, int noOfRooms, double amount, Date dateOfBook, Boolean receiptGenerated,  
			CustomerModel customers) {
		super();
		this.noOfDays = noOfDays;
		this.noOfRooms = noOfRooms;
		this.amount = amount;
		this.dateOfBook = dateOfBook;
		this.receiptGenerated = receiptGenerated;
		this.customers = customers;
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

	public CustomerModel getCustomers() {
		return customers;
	}

	public void setCustomers(CustomerModel customers) {
		this.customers = customers;
	}
}
