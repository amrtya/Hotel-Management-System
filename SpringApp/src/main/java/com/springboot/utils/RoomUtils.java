package com.springboot.utils;


import java.util.HashMap;

public class RoomUtils {

    public HashMap<Integer, Double> roomPriceStorage = new HashMap<>();
    public HashMap<String, Double> categoryWiseBasePrice = new HashMap<>();

    public RoomUtils() {
        categoryWiseBasePrice.put("NON_AC_NORMAL", 1200.00);
        categoryWiseBasePrice.put("NON_AC_DELUXE", 1500.00);
        categoryWiseBasePrice.put("AC_NORMAL", 1800.00);
        categoryWiseBasePrice.put("AC_DELUXE", 2100.00);
        categoryWiseBasePrice.put("ROYAL_SUITE", 2500.00);
    }

    public Double RoomPriceCalculation(int roomId, int noOfSingleBed, int noOfDoubleBed, String balconyFacility, String isDeluxeRoom, String category) {

        if(roomPriceStorage.containsKey(roomId))
            return roomPriceStorage.get(roomId);

        Double roomPrice = categoryWiseBasePrice.get(category);

        if(balconyFacility.equals("Y"))
            roomPrice += 300.00;
        if(isDeluxeRoom.equals("Y"))
            roomPrice += 500.00;

        roomPrice += noOfSingleBed * 250.00;
        roomPrice += noOfDoubleBed * 350.00;

        roomPriceStorage.put(roomId, roomPrice);
        return roomPrice;
    }

}
