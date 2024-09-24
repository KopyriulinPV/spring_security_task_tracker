package com.example.task_tracker.controller;

import com.example.task_tracker.entity.RoleType;
import com.example.task_tracker.mapper.UserMapper;
import com.example.task_tracker.model.request.UpsertUserRequest;
import com.example.task_tracker.model.response.UserResponse;
import com.example.task_tracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    public Flux<UserResponse> findAllUsers() {
        return userService.findAll().map(userMapper::toDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    public Mono<UserResponse> findUserById(@PathVariable String id) {
        return userService.findById(id).map(userMapper::toDto);
    }

    @PostMapping
    public Mono<UserResponse> createUser(@RequestBody UpsertUserRequest upsertUserRequest,
                                                                    @RequestParam RoleType role) {
        return userService.create(userMapper.toEntity(upsertUserRequest), role).map(userMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    public Mono<UserResponse> updateUser(@PathVariable String id, @RequestBody UpsertUserRequest upsertUserRequest) {
        return userService.update(id, userMapper.toEntity(upsertUserRequest)).map(userMapper::toDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userService.deleteById(id);
    }

}
