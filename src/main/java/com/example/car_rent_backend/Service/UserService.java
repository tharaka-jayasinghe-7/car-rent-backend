package com.example.car_rent_backend.Service;

import com.example.car_rent_backend.Data.User;
import com.example.car_rent_backend.Data.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User addUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepo.save(user);
    }

    public User authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }

    public User findUserById(int user_id) {
        Optional<User> user = userRepo.findById(user_id);
        return user.orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
