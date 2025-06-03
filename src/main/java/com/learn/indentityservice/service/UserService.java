package com.learn.indentityservice.service;

import com.learn.indentityservice.Entity.User;
import com.learn.indentityservice.Mapper.UserMapper;
import com.learn.indentityservice.dto.request.UserCreationRequest;
import com.learn.indentityservice.dto.request.UserUpdateRequest;
import com.learn.indentityservice.dto.response.UserResponse;
import com.learn.indentityservice.exception.ErrorCode;
import com.learn.indentityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    public User createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException(ErrorCode.USER_EXISTED.getMessage());
        }
        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(
                userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(UserUpdateRequest request, String id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));

        userMapper.UpdateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
