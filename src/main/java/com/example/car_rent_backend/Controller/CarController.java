package com.example.car_rent_backend.Controller;

import com.example.car_rent_backend.Data.Car;
import com.example.car_rent_backend.Service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/car")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping(path = "/getCars")
    public List<Car> getAllCars() {
        logger.debug("Received request to get all cars");
        List<Car> cars = carService.getAllCars();
        logger.info("Retrieved {} cars", cars.size());
        return cars;
    }

    @GetMapping(path = "/getCar/{car_id}")
    public ResponseEntity<?> findCarById(@PathVariable int car_id) {
        logger.debug("Received request to find car by ID: {}", car_id);
        Car car = carService.findCarById(car_id);
        if (car == null) {
            logger.warn("Car not found with ID: {}", car_id);
            return ResponseEntity.status(404).body("Car with ID " + car_id + " not found");
        }
        logger.info("Car found: {}", car);
        return ResponseEntity.ok(car);
    }

    @GetMapping(path = "/getCarByName")
    public Car getCarByName(@RequestParam String name) {
        logger.debug("Received request to find car by name: {}", name);
        Car car = carService.findCarByName(name);
        if (car == null) {
            logger.warn("Car not found with name: {}", name);
        } else {
            logger.info("Car found: {}", car);
        }
        return car;
    }
}