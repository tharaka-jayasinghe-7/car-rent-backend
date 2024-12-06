package com.example.car_rent_backend.Controller;

import com.example.car_rent_backend.Data.User;
import com.example.car_rent_backend.Data.UserResponse;
import com.example.car_rent_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User loginUser) {

        try {
            User user = userService.authenticateUser(loginUser.getEmail(), loginUser.getPassword());

            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect email or password");
            }

            UserResponse response = new UserResponse(user.getUser_id(), user.getEmail());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
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

    @GetMapping(path = "/getUserByEmail/{email}")
    public User getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return null;
        }
        else {
            return user;
        }
    }

}
