package com.example.car_rent_backend.Service;

import com.example.car_rent_backend.Data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BookingResponse> getBookingByUser(int user_id) {
        List<Booking> bookings = bookingRepo.findByUserID(user_id);
        // Convert each Booking to BookingResponse
        return bookings.stream().map(booking -> {
            String carName = booking.getCar() != null ? booking.getCar().getName() : null;
            Double carPricePerDay = booking.getCar() != null ? booking.getCar().getPrice() : null;
            return new BookingResponse(
                    booking.getBooking_id(),
                    booking.getPickup_date().toString(),  // Convert Date to String
                    booking.getNum_of_days(),
                    booking.getFull_amount(),
                    carName,
                    carPricePerDay
            );
        }).collect(Collectors.toList());
    }

    public Booking updateBooking(int user_id, int car_id, Booking booking) {
        User user = userRepo.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + user_id));
        Car car = carRepo.findById(car_id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + car_id));
        booking.setUser(user);
        booking.setCar(car);
        return bookingRepo.save(booking);
    }

    public void deleteBooking(int booking_id) {
        bookingRepo.deleteById(booking_id);
    }
}
