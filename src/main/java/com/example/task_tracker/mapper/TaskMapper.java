package com.example.task_tracker.mapper;

import com.example.task_tracker.entity.Task;
import com.example.task_tracker.model.request.UpsertTaskRequest;
import com.example.task_tracker.model.response.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {

    TaskResponse toDto(Task task);

    Task toEntity(UpsertTaskRequest upsertTaskRequest);

}
