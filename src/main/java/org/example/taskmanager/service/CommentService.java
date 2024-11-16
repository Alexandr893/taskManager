package org.example.taskmanager.service;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.entity.Comment;
import org.example.taskmanager.dao.entity.Task;
import org.example.taskmanager.dao.entity.User;
import org.example.taskmanager.dao.repository.CommentRepository;
import org.example.taskmanager.dao.repository.TaskRepository;
import org.example.taskmanager.dao.repository.UserRepository;
import org.example.taskmanager.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment createComment(CommentDto commentDto) {
        User author = userRepository.findById(commentDto.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Автор не найден"));
        Task task = taskRepository.findById(commentDto.getTaskId())
                .orElseThrow(() -> new IllegalArgumentException("Задача не найдена"));

        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setAuthor(author);
        comment.setTask(task);

        return commentRepository.save(comment);
    }


}
