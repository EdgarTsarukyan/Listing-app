package com.example.listingapp.endpoint;

import com.example.listingapp.entity.Category;
import com.example.listingapp.entity.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> users(){
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable("id") int id) {
        Optional<User> byId = userService.findUsersById(id);

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return ResponseEntity.ok(byId.get());
    }



    @PostMapping("/users")
    public ResponseEntity<User> user(@RequestBody User user) {
    return   userService.addUSer(user);

    }

    @PutMapping("/users")
    public ResponseEntity<User> putUser(@RequestBody User user) {


        return userService.addUSer(user);

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        Optional<User> byId = userService.findUsersById(id);

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        userService.deleteUserById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
