package com.example.task_tracker.mapper;

import com.example.task_tracker.entity.User;
import com.example.task_tracker.model.request.UpsertUserRequest;
import com.example.task_tracker.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserResponse toDto(User user);

    User toEntity(UpsertUserRequest upsertUserRequest);
}
