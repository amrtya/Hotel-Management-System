package com.springboot.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class GenericUtils {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public String formatDate(String date) {
        LocalDate formattedDate = LocalDate.parse(date, formatter);
        return formattedDate.toString();
    }

    public int durationBetweenDates(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        return Period.between(start, end).getDays();
    }
}
