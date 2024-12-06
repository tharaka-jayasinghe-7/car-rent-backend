package com.example.car_rent_backend.Data;

public class BookingResponse {
    private int bookingId;
    private String pickupDate;
    private int numOfDays;
    private Double fullAmount;
    private String carName;
    private Double carPricePerDay;

    // Constructor
    public BookingResponse(int bookingId, String pickupDate, int numOfDays, Double fullAmount, String carName, Double carPricePerDay) {
        this.bookingId = bookingId;
        this.pickupDate = pickupDate;
        this.numOfDays = numOfDays;
        this.fullAmount = fullAmount;
        this.carName = carName;
        this.carPricePerDay = carPricePerDay;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public Double getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(Double fullAmount) {
        this.fullAmount = fullAmount;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getCarPricePerDay() {
        return carPricePerDay;
    }

    public void setCarPricePerDay(Double carPricePerDay) {
        this.carPricePerDay = carPricePerDay;
    }
}

