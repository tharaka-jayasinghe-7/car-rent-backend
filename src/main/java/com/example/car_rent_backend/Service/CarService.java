package com.example.car_rent_backend.Service;

import com.example.car_rent_backend.Data.Car;
import com.example.car_rent_backend.Data.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }
}
