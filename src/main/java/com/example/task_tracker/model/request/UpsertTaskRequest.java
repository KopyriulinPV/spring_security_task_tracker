package com.example.task_tracker.model.request;


import com.example.task_tracker.entity.TaskStatus;
import com.example.task_tracker.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertTaskRequest {

    private String id;

    private String name;

    private String description;

    private TaskStatus status;

    private String authorId;

    private String assigneeId;

    private List<String> observerIds;

}
