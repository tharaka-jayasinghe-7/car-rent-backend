package com.example.car_rent_backend.Data;

public class UserResponse {

    private int user_id;
    private String email;

    public UserResponse(int user_id, String email) {
        this.user_id = user_id;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

