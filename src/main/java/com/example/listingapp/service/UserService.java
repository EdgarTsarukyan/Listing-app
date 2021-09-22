package com.example.listingapp.service;

import com.example.listingapp.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    Optional<User> findUsersById(int id);

   ResponseEntity <User> addUSer(User user);

    void deleteUserById(int id);
}
