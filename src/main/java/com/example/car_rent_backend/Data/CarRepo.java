package com.example.car_rent_backend.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
    @Query("SELECT c FROM Car c where  c.name = ?1")
    Car findCarByName(String name);
}
