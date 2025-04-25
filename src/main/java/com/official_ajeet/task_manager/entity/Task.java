package com.official_ajeet.task_manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Data
public class Task {
    private Long taskId;
    private String title;
    private Long userId;

    // No-args constructor
    public Task() {
    }

    // All-args constructor
    public Task(Long id, String title, Long userId) {
        this.taskId = id;
        this.title = title;
        this.userId = userId;
    }

    // Getter and Setter for id
    public Long getTaskId() {
        return taskId;
    }

    public void setId(Long id) {
        this.taskId = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
