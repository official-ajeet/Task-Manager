package com.official_ajeet.task_manager.controller;

import com.official_ajeet.task_manager.entity.Task;
import com.official_ajeet.task_manager.service.TaskService;
import com.official_ajeet.task_manager.storage.InMemoryStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private TaskService taskService;
    private  InMemoryStorage inMemoryStorage;

    public TaskController(TaskService taskService, InMemoryStorage inMemoryStorage) {
        this.taskService = taskService;
        this.inMemoryStorage = inMemoryStorage;
    }

public Long extractUserId(String token) {
    Long userId = inMemoryStorage.tokens.get(token); // ✔️ Use the token as key
    if (userId == null) {
        throw new RuntimeException("Invalid token: " + token);
    }
    return userId;
}


    @PostMapping("/add")
    public ResponseEntity<String>addTask(@RequestHeader("Authorization") String token,
                                         @RequestBody Map<String, String> body){
        if (token.startsWith("Bearer ")) {
            token = token.substring(7); // removes "Bearer " (with space)
        }
        Long userId = extractUserId(token);
        taskService.addTask(userId, body.get("title"));
        return ResponseEntity.ok("Task added");
    }

    @GetMapping("/get")
    public ResponseEntity<List<Task>> getTasks(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7); // removes "Bearer " (with space)
        }
        Long userId = extractUserId(token);
        return ResponseEntity.ok(taskService.getTasks(userId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@RequestHeader("Authorization") String token,
                                        @PathVariable Long id) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7); // removes "Bearer " (with space)
        }
        Long userId = extractUserId(token);
        taskService.deleteTask(userId, id);
        return ResponseEntity.ok("Task deleted");
    }
}
