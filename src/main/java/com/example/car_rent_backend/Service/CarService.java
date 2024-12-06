package com.example.car_rent_backend.Service;

import com.example.car_rent_backend.Data.Car;
import com.example.car_rent_backend.Data.CarRepo;
import com.example.car_rent_backend.Data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public List<Car> getAllCars() {
        return carRepo.findAll(Sort.by(Sort.Order.asc("price")));
    }

    public Car findCarById(int car_id) {
        Optional<Car> car = carRepo.findById(car_id);
        if (car.isPresent()) {
            return car.get();
        }
        return null;
    }

    public Car findCarByName(String name) {
        return carRepo.findCarByName(name);
    }
}
