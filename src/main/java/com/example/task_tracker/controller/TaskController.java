package com.example.task_tracker.controller;

import com.example.task_tracker.mapper.TaskMapper;
import com.example.task_tracker.model.request.UpsertTaskRequest;
import com.example.task_tracker.model.response.TaskResponse;
import com.example.task_tracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    public Flux<TaskResponse> findAllTasks() {
        return taskService.findAll().map(taskMapper::toDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    public Mono<TaskResponse> findTaskById(@PathVariable String id) {
        return taskService.findById(id).map(taskMapper::toDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public Mono<TaskResponse> createTask(@RequestBody UpsertTaskRequest upsertTaskRequest) {
        return taskService.create(taskMapper.toEntity(upsertTaskRequest)).map(taskMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public Mono<TaskResponse> updateTask(@PathVariable String id, @RequestBody UpsertTaskRequest upsertTaskRequest) {
        return taskService.update(id, taskMapper.toEntity(upsertTaskRequest)).map(taskMapper::toDto);
    }

    @PutMapping("/{id}/addObserver")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    public Mono<TaskResponse> addObserver(@PathVariable String id, @RequestBody String observerId) {
        return taskService.addObserver(id, observerId).map(taskMapper::toDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public Mono<Void> deleteTask(@PathVariable String id) {
        return taskService.deleteById(id);
    }
}
