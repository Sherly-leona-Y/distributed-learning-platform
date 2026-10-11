
package com.learningplatform.userservice.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.learningplatform.userservice.model.User;
import com.learningplatform.userservice.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(User user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Email already registered"
            );
        }
        return repository.save(user);
    }

    public User login(String email, String password) {
        User user = repository.findByEmail(email)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "Invalid email or password"
            ));

        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "Invalid email or password"
            );
        }

        return user;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}
