package com.example.car_rent_backend.Controller;

import com.example.car_rent_backend.Data.Booking;
import com.example.car_rent_backend.Data.BookingResponse;
import com.example.car_rent_backend.Service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;

    @PostMapping("/user/{user_id}/car/{car_id}/addBooking")
    public ResponseEntity<Booking> addBooking(@PathVariable int user_id, @PathVariable int car_id, @RequestBody Booking booking) {
        logger.debug("Received request to add booking: user_id={}, car_id={}, booking={}", user_id, car_id, booking);
        Booking createdBooking = bookingService.addBooking(user_id, car_id, booking);
        logger.info("Booking created successfully: {}", createdBooking);
        return ResponseEntity.ok(createdBooking);
    }

    @GetMapping("/user/{user_id}/getBookingByUser")
    public ResponseEntity<List<BookingResponse>> getBookingByUser(@PathVariable int user_id) {
        logger.debug("Received request to get bookings for user_id={}", user_id);
        List<BookingResponse> bookingResponses = bookingService.getBookingByUser(user_id);
        logger.info("Retrieved {} bookings for user_id={}", bookingResponses.size(), user_id);
        return ResponseEntity.ok(bookingResponses);
    }

    @PutMapping("/user/{user_id}/car/{car_id}/updateBooking/{booking_id}")
    public Booking updateBooking(@PathVariable int user_id, @PathVariable int car_id, @PathVariable int booking_id, @RequestBody Booking booking) {
        logger.debug("Received request to update booking: user_id={}, car_id={}, booking_id={}, booking={}", user_id, car_id, booking_id, booking);
        booking.setBooking_id(booking_id);
        Booking updatedBooking = bookingService.updateBooking(user_id, car_id, booking);
        logger.info("Booking updated successfully: {}", updatedBooking);
        return updatedBooking;
    }

    @DeleteMapping("/deleteBooking/{booking_id}")
    public void deleteBooking(@PathVariable int booking_id) {
        logger.debug("Received request to delete booking with booking_id={}", booking_id);
        bookingService.deleteBooking(booking_id);
        logger.info("Booking deleted successfully with booking_id={}", booking_id);
    }
}
