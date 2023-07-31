package com.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class RoomModel {
	
	public static String VACANT = "VACANT", OCCUPIED = "OCCUPIED";
	
	@Id
	private int roomId; 
	
	@Column(precision = 2)
	private Double price; 
	private String isOccupied; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "revId")
	private ReservationModel reservations;
	
	public RoomModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomModel(int roomId, Double price, String isOccupied) {
		super();
		this.roomId = roomId;
		this.price = price;
		this.isOccupied = RoomModel.VACANT;
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

	public String getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(String isOccupied) {
		this.isOccupied = isOccupied;
	}
	
}
