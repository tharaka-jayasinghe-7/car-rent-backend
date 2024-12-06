package com.example.car_rent_backend.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date pickup_date;
    private int num_of_days;
    private Double full_amount;

    @ManyToOne
    @JsonBackReference("user-bookings")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonBackReference("car-bookings")
    private Car car;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public int getNum_of_days() {
        return num_of_days;
    }

    public void setNum_of_days(int num_of_days) {
        this.num_of_days = num_of_days;
    }

    public Double getFull_amount() {
        return full_amount;
    }

    public void setFull_amount(Double full_amount) {
        this.full_amount = full_amount;
    }
}
