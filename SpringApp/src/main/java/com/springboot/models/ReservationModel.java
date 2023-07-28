package com.springboot.models;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table
public class ReservationModel {
	
	public static String PENDING = "PENDING", APPROVED = "APPROVED", REJECTED = "REJECTED";
	
	@Id 
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	private String revId;
	private int noOfDays;
	private int noOfRooms; 

	@Column(precision = 2)
	private double amount; 
	private Date dateOfBook;
	private Boolean receiptGenerated;
	private Date checkoutDate;
	private String approvalStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserModel users;
	

	public ReservationModel() {
		super();
	}
	
	public ReservationModel(int noOfDays, int noOfRooms, double amount, Date dateOfBook, Boolean receiptGenerated, Date checkoutDate, 
			UserModel users) {
		super();
		this.noOfDays = noOfDays;
		this.noOfRooms = noOfRooms;
		this.amount = amount;
		this.dateOfBook = dateOfBook;
		this.receiptGenerated = receiptGenerated;
		this.checkoutDate = checkoutDate;
		this.approvalStatus = ReservationModel.PENDING;
		this.users = users;
	}
		
	public String getRevId() {
		return revId;
	}

	public void setRevId(String revId) {
		this.revId = revId;
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

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public UserModel getUsers() {
		return users;
	}

	public void setUsers(UserModel users) {
		this.users = users;
	}
}
