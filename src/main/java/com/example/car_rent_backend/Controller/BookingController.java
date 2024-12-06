package com.example.car_rent_backend.Controller;

import com.example.car_rent_backend.Data.Booking;
import com.example.car_rent_backend.Data.BookingResponse;
import com.example.car_rent_backend.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/user/{user_id}/car/{car_id}/addBooking")
    public ResponseEntity<Booking> addBooking(@PathVariable int user_id, @PathVariable int car_id, @RequestBody Booking booking) {
        Booking createdBooking = bookingService.addBooking(user_id, car_id, booking);
        return ResponseEntity.ok(createdBooking);
    }

    @GetMapping("/user/{user_id}/getBookingByUser")
    public ResponseEntity<List<BookingResponse>> getBookingByUser(@PathVariable int user_id) {
        List<BookingResponse> bookingResponses = bookingService.getBookingByUser(user_id);
        return ResponseEntity.ok(bookingResponses);
    }

    @PutMapping("user/{user_id}/car/{car_id}/updateBooking/{booking_id}")
    public Booking updateBooking(@PathVariable int user_id, @PathVariable int car_id, @PathVariable int booking_id, @RequestBody Booking booking) {
        booking.setBooking_id(booking_id);
        return bookingService.updateBooking(user_id, car_id, booking);
    }

    @DeleteMapping("/deleteBooking/{booking_id}")
    public void deleteBooking(@PathVariable int booking_id) {
        bookingService.deleteBooking(booking_id);
    }

}
