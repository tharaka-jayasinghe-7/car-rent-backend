package com.example.car_rent_backend.Controller;

import com.example.car_rent_backend.Data.User;
import com.example.car_rent_backend.Data.UserResponse;
import com.example.car_rent_backend.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(path = "/addUser")
    public User addUser(@RequestBody User user) {
        logger.debug("Received request to add user: {}", user);
        User createdUser = userService.addUser(user);
        logger.info("User created successfully: {}", createdUser);
        return createdUser;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User loginUser) {
        logger.debug("Received login request for email: {}", loginUser.getEmail());
        try {
            User user = userService.authenticateUser(loginUser.getEmail(), loginUser.getPassword());

            if (user == null) {
                logger.warn("Login failed for email: {} - Incorrect email or password", loginUser.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect email or password");
            }

            UserResponse response = new UserResponse(user.getUser_id(), user.getEmail());
            logger.info("Login successful for email: {}", loginUser.getEmail());
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("An error occurred during login for email: {}", loginUser.getEmail(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
        }
    }

    @GetMapping(path = "/getUser/{user_id}")
    public ResponseEntity<?> findUserById(@PathVariable int user_id) {
        logger.debug("Received request to find user by ID: {}", user_id);
        User user = userService.findUserById(user_id);
        if (user == null) {
            logger.warn("User not found with ID: {}", user_id);
            return ResponseEntity.status(404).body("User with ID " + user_id + " not found");
        }
        logger.info("User found: {}", user);
        return ResponseEntity.ok(user);
    }

    @GetMapping(path = "/getUserByEmail/{email}")
    public User getUserByEmail(@PathVariable String email) {
        logger.debug("Received request to find user by email: {}", email);
        User user = userService.getUserByEmail(email);
        if (user == null) {
            logger.warn("User not found with email: {}", email);
            return null;
        }
        logger.info("User found: {}", user);
        return user;
    }
}
