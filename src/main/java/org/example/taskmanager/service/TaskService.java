package org.example.taskmanager.service;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.entity.Task;
import org.example.taskmanager.dao.entity.User;
import org.example.taskmanager.dao.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findByAuthor(User author) {
        return taskRepository.findByAuthor(author);
    }

    public List<Task> findByAssignee(User assignee) {
        return taskRepository.findByAssignee(assignee);
    }

}
