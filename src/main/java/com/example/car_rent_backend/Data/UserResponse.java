package com.example.car_rent_backend.Data;

public class UserResponse {

    private int user_id;
    private String email;

    // Constructor
    public UserResponse(int user_id, String email) {
        this.user_id = user_id;
        this.email = email;
    }

    // Getter for user_id
    public int getUser_id() {
        return user_id;
    }

    // Setter for user_id
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
}

