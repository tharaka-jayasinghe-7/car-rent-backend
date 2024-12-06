package com.example.car_rent_backend.Controller;

import com.example.car_rent_backend.Data.Car;
import com.example.car_rent_backend.Data.User;
import com.example.car_rent_backend.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(path = "/getCars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping(path = "/getCar/{car_id}")
    public ResponseEntity<?> findCarById(@PathVariable int car_id) {
        Car car = carService.findCarById(car_id);
        if (car == null) {
            return ResponseEntity.status(404).body("Car with ID " + car_id + " not found");
        }
        return ResponseEntity.ok(car);
    }

    @GetMapping(path = "/getCarByName")
    public Car getCarByName(@RequestParam String name) {
        return carService.findCarByName(name);
    }

}
