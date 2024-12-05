package com.example.car_rent_backend.Controller;

import com.example.car_rent_backend.Data.Car;
import com.example.car_rent_backend.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(path = "/getCars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
}
