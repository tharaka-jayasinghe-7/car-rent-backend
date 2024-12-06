package com.example.car_rent_backend.Service;

import com.example.car_rent_backend.Data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private BookingRepo bookingRepo;

    public Booking addBooking( int user_id, int car_id ,Booking booking) {
        User user = userRepo.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + user_id));

        Car car = carRepo.findById(car_id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + car_id));

        booking.setUser(user);
        booking.setCar(car);

        return bookingRepo.save(booking);
    }
    public List<Booking> getBookingByUser(int user_id) {
        return bookingRepo.findByUserID(user_id);
    }

}
