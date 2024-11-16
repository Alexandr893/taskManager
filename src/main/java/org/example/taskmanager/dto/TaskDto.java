package org.example.taskmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Long authorId;
    private Long assigneeId;
    private String status;
    private String priority;
}
