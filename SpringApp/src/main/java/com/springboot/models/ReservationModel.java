package com.springboot.models;

import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name = "REV_DETAILS")
@DynamicUpdate
@DynamicInsert
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
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
	private String checkInDate;
	private Boolean receiptGenerated;
	private String checkoutDate;
	private String approvalStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserModel users;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reservations", cascade = CascadeType.ALL)
	private List<RoomModel> roomModels;

	public ReservationModel() {
		super();
	}
	
	public ReservationModel(int noOfRooms, String checkInDate, Boolean receiptGenerated, String checkoutDate, 
			UserModel users) {
		super();
		
		this.noOfRooms = noOfRooms;
		this.checkInDate = checkInDate;
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

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Boolean getReceiptGenerated() {
		return receiptGenerated;
	}

	public void setReceiptGenerated(Boolean receiptGenerated) {
		this.receiptGenerated = receiptGenerated;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
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
