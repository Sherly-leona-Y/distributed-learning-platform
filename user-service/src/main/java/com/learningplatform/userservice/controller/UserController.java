
package com.learningplatform.userservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.learningplatform.userservice.model.User;
import com.learningplatform.userservice.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "https://learnhub-frontend-0a0t.onrender.com")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        User saved = service.register(user);

        return Map.of(
            "id", saved.getId(),
            "name", saved.getName(),
            "email", saved.getEmail(),
            "message", "Registration successful"
        );
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || password == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Email and password are required"
            );
        }

        User user = service.login(email, password);

        return Map.of(
            "id", user.getId(),
            "name", user.getName(),
            "email", user.getEmail(),
            "message", "Login successful"
        );
    }

    @GetMapping
    public List<Map<String, Object>> getUsers() {
        return service.getUsers().stream()
            .map(user -> Map.<String, Object>of(
                "id", user.getId(),
                "name", user.getName(),
                "email", user.getEmail()
            ))
            .toList();
    }
}
