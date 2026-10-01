package com.learningplatform.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learningplatform.userservice.model.User;
import com.learningplatform.userservice.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}