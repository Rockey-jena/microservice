package com.userService.service;

import com.userService.entity.User;

import java.util.List;

public interface UserService {
User create (User user);
List<User>getAll();

    User updateUser(User updatedUser) ;

    // Delete
     void deleteUser(long userId) ;

    User getUserById(long userId);
}
