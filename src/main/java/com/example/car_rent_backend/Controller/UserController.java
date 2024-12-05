package com.example.car_rent_backend.Controller;

import com.example.car_rent_backend.Data.User;
import com.example.car_rent_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticateUser(user.getEmail(), user.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("User logged in");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Email or Password");
        }
    }

    @GetMapping(path = "/getUser/{user_id}")
    public ResponseEntity<?> findUserById(@PathVariable int user_id) {
        User user = userService.findUserById(user_id);
        if (user == null) {
            return ResponseEntity.status(404).body("User with ID " + user_id + " not found");
        }
        return ResponseEntity.ok(user);
    }



}
