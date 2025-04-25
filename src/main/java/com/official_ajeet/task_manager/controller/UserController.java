package com.official_ajeet.task_manager.controller;

import com.official_ajeet.task_manager.dto.AuthRequest;
import com.official_ajeet.task_manager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final AuthService authService;
    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String>register(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.register(authRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        String token = authService.login(authRequest);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
