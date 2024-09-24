package com.example.task_tracker.model.response;

import com.example.task_tracker.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {

    private String id;

    private String name;

    private String description;

    private TaskStatus status;

    private String authorId;

    private String assigneeId;

    private List<String> observerIds;

}
