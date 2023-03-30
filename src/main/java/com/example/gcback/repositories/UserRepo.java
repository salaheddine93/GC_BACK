package com.example.gcback.repositories;

import com.example.gcback.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername (String username);
}
