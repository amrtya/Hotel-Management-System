package com.springboot.dto;

public class AddRoomDTO {

    private int roomId;
    private int noOfSingleBed;
    private int noOfDoubleBed;
    private String balconyFacility;
    private String isDeluxeRoom;
    private String category;

    public AddRoomDTO(int roomId, int noOfSingleBed, int noOfDoubleBed, String balconyFacility, String isDeluxeRoom, String category) {
        this.roomId = roomId;
        this.noOfSingleBed = noOfSingleBed;
        this.noOfDoubleBed = noOfDoubleBed;
        this.balconyFacility = balconyFacility;
        this.isDeluxeRoom = isDeluxeRoom;
        this.category = category;
    }

    public int getNoOfSingleBed() {
        return noOfSingleBed;
    }

    public void setNoOfSingleBed(int noOfSingleBed) {
        this.noOfSingleBed = noOfSingleBed;
    }

    public String getBalconyFacility() {
        return balconyFacility;
    }

    public void setBalconyFacility(String balconyFacility) {
        this.balconyFacility = balconyFacility;
    }

    public String getIsDeluxeRoom() {
        return isDeluxeRoom;
    }

    public void setIsDeluxeRoom(String isDeluxeRoom) {
        this.isDeluxeRoom = isDeluxeRoom;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfDoubleBed() {
        return noOfDoubleBed;
    }

    public void setNoOfDoubleBed(int noOfDoubleBed) {
        this.noOfDoubleBed = noOfDoubleBed;
    }
}
