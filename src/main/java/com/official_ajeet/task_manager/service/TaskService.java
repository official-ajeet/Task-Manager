package com.official_ajeet.task_manager.service;

import com.official_ajeet.task_manager.entity.Task;
import com.official_ajeet.task_manager.storage.InMemoryStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final InMemoryStorage inMemoryStorage;

    public TaskService(InMemoryStorage inMemoryStorage) {
        this.inMemoryStorage = inMemoryStorage;
    }

    public void addTask(Long userId, String title){
        Task task = new Task(System.currentTimeMillis(), title, userId);
        inMemoryStorage.task.computeIfAbsent(userId, t -> new ArrayList<>()).add(task);
    }

    public List<Task> getTasks(Long userId){
        return inMemoryStorage.task.getOrDefault(userId, new ArrayList<>());
    }

    public void deleteTask(Long userId, Long taskId){
        List<Task>tasks = inMemoryStorage.task.get(userId);
        if(tasks != null){
            tasks.removeIf(task -> task.getTaskId().equals(taskId));
        }
    }


}
