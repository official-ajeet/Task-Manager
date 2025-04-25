package com.official_ajeet.task_manager.storage;

import com.official_ajeet.task_manager.entity.Task;
import com.official_ajeet.task_manager.entity.User;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class InMemoryStorage {
    public Map<String, User>users = new HashMap<>();
    public Map<Long, List<Task>>task = new HashMap<>();
    public Map<String, Long>tokens = new HashMap<>();

    public long getUserId(String token){
        Long userId = tokens.get(token);
        if (userId == null) {
            throw new RuntimeException("Invalid token: " + token);
        }
        return userId;
    }

    public String generateToken(Long userId){
        String token = UUID.randomUUID().toString();
        tokens.put(token, userId);
        return token;
    }
}
