package com.userService.controller;

import com.userService.entity.User;
import com.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);

    }
@GetMapping
    public ResponseEntity<List<User>>getAll(){
        return ResponseEntity.ok(userService.getAll());
}

    @GetMapping("/{userId}")
    public User getUserByID(@PathVariable long userId) {
        return  userService.getUserById(userId);

    }


    // Update
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable long userId, @RequestBody User updatedUser) {
        updatedUser.setUserId(userId); // Make sure the ID is set for update
        return userService.updateUser(updatedUser);
    }

    // Delete
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }
}