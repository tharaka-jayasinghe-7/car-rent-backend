package com.example.car_rent_backend.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    @Query("SELECT b FROM Booking b WHERE b.user.user_id = :user_id")
    List<Booking> findByUserID(int user_id);
}
