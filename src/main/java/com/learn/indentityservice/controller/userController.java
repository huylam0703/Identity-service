package com.learn.indentityservice.controller;


import com.learn.indentityservice.Entity.User;
import com.learn.indentityservice.dto.request.UserCreationRequest;
import com.learn.indentityservice.dto.request.UserUpdateRequest;
import com.learn.indentityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userid}")
    User getUserById(@PathVariable("userid") String userid) {
        return userService.getUser(userid);
    }

    @PutMapping("/{userid}")
    User updateUser(@PathVariable String userid, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(request, userid);
    }

    @DeleteMapping("/{userid}")
    String deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
        return "Deleted User";
    }

}
