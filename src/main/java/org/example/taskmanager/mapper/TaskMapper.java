package org.example.taskmanager.mapper;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.entity.Task;
import org.example.taskmanager.dto.TaskDto;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskMapper {
    public  TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setAuthorId(task.getAuthor().getId());
        dto.setAssigneeId(task.getAssignee().getId());
        dto.setStatus(task.getStatus().name());
        dto.setPriority(task.getPriority().name());
        return dto;
    }
}
