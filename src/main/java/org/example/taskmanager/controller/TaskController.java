package org.example.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.entity.Task;
import org.example.taskmanager.dto.TaskDto;
import org.example.taskmanager.mapper.TaskMapper;
import org.example.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;
    private TaskMapper taskMapper;

    @GetMapping("/author/{authorId}")
    public List<TaskDto> getTasksByAuthor(@PathVariable Long authorId) {
        return taskService.findByAuthor(authorId).stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/assignee/{assigneeId}")
    public List<TaskDto> getTasksByAssignee(@PathVariable Long assigneeId) {
        return taskService.findByAssignee(assigneeId).stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDTO) {
        Task task = taskService.createTask(taskDTO);
        return ResponseEntity.ok(taskMapper.toDto(task));
    }

}
