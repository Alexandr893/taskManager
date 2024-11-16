package org.example.taskmanager.mapper;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.entity.Comment;
import org.example.taskmanager.dto.CommentDto;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentMapper {
    public CommentDto toDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setText(comment.getText());
        dto.setAuthorId(comment.getAuthor().getId());
        dto.setTaskId(comment.getTask().getId());
        return dto;
    }
}
