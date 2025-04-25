package com.official_ajeet.task_manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class User {
    private Long userId;
    private String username;
    private String password;

    // No-args constructor
    public User() {
    }

    // All-args constructor
    public User(Long id, String username, String password) {
        this.userId = id;
        this.username = username;
        this.password = password;
    }

    // Getter and Setter for id
    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
