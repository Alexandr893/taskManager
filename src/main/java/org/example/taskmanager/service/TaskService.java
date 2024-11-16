package org.example.taskmanager.service;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.entity.Task;
import org.example.taskmanager.dao.entity.User;
import org.example.taskmanager.dao.repository.TaskRepository;
import org.example.taskmanager.dao.repository.UserRepository;
import org.example.taskmanager.dto.TaskDto;
import org.example.taskmanager.enums.Priority;
import org.example.taskmanager.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public List<Task> findByAuthor(Long authorId) {
        User author = userRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("Автор не найден"));
        return taskRepository.findByAuthor(author);
    }

    public List<Task> findByAssignee(Long assigneeId) {
        User assignee = userRepository.findById(assigneeId).orElseThrow(() -> new IllegalArgumentException("Исполнитель не найден"));
        return taskRepository.findByAssignee(assignee);
    }

    public Task createTask(TaskDto taskDto) {
        User author = userRepository.findById(taskDto.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("Автор не найден"));
        User assignee = userRepository.findById(taskDto.getAssigneeId()).orElseThrow(() -> new IllegalArgumentException("Исполнитель не найден"));

        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setAuthor(author);
        task.setAssignee(assignee);
        task.setStatus(Status.valueOf(taskDto.getStatus()));
        task.setPriority(Priority.valueOf(taskDto.getPriority()));

        return taskRepository.save(task);
    }


}
