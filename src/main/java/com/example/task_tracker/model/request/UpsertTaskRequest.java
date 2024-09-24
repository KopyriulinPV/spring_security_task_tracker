package com.example.task_tracker.model.request;

import com.example.task_tracker.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


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
