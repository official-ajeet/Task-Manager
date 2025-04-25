package com.official_ajeet.task_manager.service;

import com.official_ajeet.task_manager.dto.AuthRequest;
import com.official_ajeet.task_manager.entity.User;
import com.official_ajeet.task_manager.storage.InMemoryStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final InMemoryStorage inMemoryStorage;

    public AuthService(InMemoryStorage inMemoryStorage) {
        this.inMemoryStorage = inMemoryStorage;
    }
    public String register(AuthRequest authRequest){
        if(inMemoryStorage.users.containsKey(authRequest.getUsername())){
            throw new RuntimeException("User already exists with username: "+authRequest.getUsername());
        }
        User user = new User(System.currentTimeMillis(), authRequest.getUsername(), authRequest.getPassword());

        inMemoryStorage.users.put(authRequest.getUsername(), user);
        return "User registered with username: "+authRequest.getUsername();
    }

    public String login(AuthRequest authRequest){
        User user = inMemoryStorage.users.get(authRequest.getUsername());
        if(user == null || !user.getPassword().equals(authRequest.getPassword())){
            throw new RuntimeException("Invalid Login Credentials!");
        }
        return inMemoryStorage.generateToken(user.getUserId());
    }
}
