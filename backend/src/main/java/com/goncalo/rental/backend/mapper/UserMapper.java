package com.goncalo.rental.backend.mapper;

import com.goncalo.rental.backend.model.dto.request.UserRequest;
import com.goncalo.rental.backend.model.dto.response.UserResponse;
import com.goncalo.rental.backend.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
    User toEntity(UserRequest userRequest);
}
