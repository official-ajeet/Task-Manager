package com.official_ajeet.task_manager.dto;

import lombok.Data;

//for login and register users
//@Data
public class AuthRequest {
    private String username;
    private String password;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
