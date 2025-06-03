package com.learn.indentityservice.controller;


import com.learn.indentityservice.Entity.User;
import com.learn.indentityservice.dto.request.ApiResponse;
import com.learn.indentityservice.dto.request.UserCreationRequest;
import com.learn.indentityservice.dto.request.UserUpdateRequest;
import com.learn.indentityservice.dto.response.UserResponse;
import com.learn.indentityservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/users")
public class userController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userid}")
    UserResponse getUserById(@PathVariable("userid") String userid) {
        return userService.getUser(userid);
    }

    @PutMapping("/{userid}")
    UserResponse updateUser(@PathVariable String userid, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(request, userid);
    }

    @DeleteMapping("/{userid}")
    String deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
        return "Deleted User";
    }

}
