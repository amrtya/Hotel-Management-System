package com.springboot.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class RoomModel {
	
	@Id
	private int roomId; 
	
	@Column(precision = 2)
	private Double price; 
	private Boolean isOccupied; 
	private Date checkoutDate;
	
	public RoomModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomModel(int roomId, Double price, Boolean isOccupied, Date checkoutDate) {
		super();
		this.roomId = roomId;
		this.price = price;
		this.isOccupied = isOccupied;
		this.checkoutDate = checkoutDate;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(Boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}	
}
