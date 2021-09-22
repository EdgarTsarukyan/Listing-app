package com.example.listingapp.service.impl;

import com.example.listingapp.entity.User;
import com.example.listingapp.repository.UserRepository;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUsersById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public ResponseEntity<User> addUSer(@RequestBody User user) {
        userRepository.save(user);

        Optional<User> byId = userRepository.findById(user.getId());

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        userRepository.save(user);

        return ResponseEntity
                .ok()
                .body(userRepository.save(user));
    }








    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
