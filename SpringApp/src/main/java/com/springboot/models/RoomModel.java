package com.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table
public class RoomModel {
	
	public static String VACANT = "VACANT", OCCUPIED = "OCCUPIED";
	
	@TableGenerator(name = "id-gen", initialValue = 100, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id-gen")
	private int roomId; 
	
	@Column(precision = 2)
	private Double price; 
	private String isOccupied; 
	private int noOfBed;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "revId")
	private ReservationModel reservations;
	
	public RoomModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomModel(int roomId, Double price, String isOccupied, int noOfBed) {
		super();
		this.roomId = roomId;
		this.price = price;
		this.isOccupied = RoomModel.VACANT;
		this.noOfBed = noOfBed;
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

	public int getNoOfBed() {
		return noOfBed;
	}

	public void setNoOfBed(int noOfBed) {
		this.noOfBed = noOfBed;
	}

	public ReservationModel getReservations() {
		return reservations;
	}

	public void setReservations(ReservationModel reservations) {
		this.reservations = reservations;
	}
	
}
