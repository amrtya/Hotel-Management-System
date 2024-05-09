package com.springboot.models;

import com.springboot.dto.AddRoomDTO;
import com.springboot.utils.RoomUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "ROOM_DETAILS")
public class RoomModel {

	public static String VACANT = "VACANT", OCCUPIED = "OCCUPIED", CLEAN = "Under Cleaning";

	@Id
	private int roomId; 
	
	@Column(precision = 2)
	private Double price; 
	private String status;
	private int singleBed;
	private int doubleBed;
	private String balcony;
	private String deluxe;
	private String categoryType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "revId")
	private ReservationModel reservations;

	public RoomModel() {
		super();
	}

	public RoomModel(AddRoomDTO addRoomDTO) {
		super();
        this.status = RoomModel.VACANT;
		this.roomId = addRoomDTO.getRoomId();
		this.singleBed = addRoomDTO.getNoOfSingleBed();
		this.doubleBed = addRoomDTO.getNoOfDoubleBed();
		this.balcony = addRoomDTO.getBalconyFacility();
		this.deluxe = addRoomDTO.getIsDeluxeRoom();
		this.categoryType = addRoomDTO.getCategory();

		this.price = new RoomUtils().RoomPriceCalculation(this.roomId, this.singleBed, this.doubleBed, this.balcony, this.deluxe, this.categoryType);
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
		return status;
	}

	public void setIsOccupied(String status) {
		this.status = status;
	}

	public int getNoOfSingleBed() {
		return singleBed;
	}

	public void setNoOfSingleBed(int noOfSingleBed) {
		this.singleBed = noOfSingleBed;
	}

	public int getNoOfDoubleBed() {
		return doubleBed;
	}

	public void setNoOfDoubleBed(int noOfDoubleBed) {
		this.doubleBed = noOfDoubleBed;
	}

	public ReservationModel getReservations() {
		return reservations;
	}

	public void setReservations(ReservationModel reservations) {
		this.reservations = reservations;
	}

	public String getBalconyFacility() {
		return balcony;
	}

	public void setBalconyFacility(String balconyFacility) {
		this.balcony = balconyFacility;
	}

	public String getIsDeluxeRoom() {
		return deluxe;
	}

	public void setIsDeluxeRoom(String isDeluxeRoom) {
		this.deluxe = isDeluxeRoom;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
}
