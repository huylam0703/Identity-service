package com.learn.indentityservice.Mapper;

import com.learn.indentityservice.Entity.User;
import com.learn.indentityservice.dto.request.UserCreationRequest;
import com.learn.indentityservice.dto.request.UserUpdateRequest;
import com.learn.indentityservice.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    void UpdateUser(@MappingTarget User user, UserUpdateRequest request);
    UserResponse toUserResponse(User user);

}
