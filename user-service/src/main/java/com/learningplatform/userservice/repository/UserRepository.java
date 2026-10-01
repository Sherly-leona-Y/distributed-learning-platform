package com.learningplatform.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningplatform.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}