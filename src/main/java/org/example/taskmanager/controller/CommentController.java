package org.example.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.entity.Comment;
import org.example.taskmanager.dto.CommentDto;
import org.example.taskmanager.mapper.CommentMapper;
import org.example.taskmanager.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @GetMapping
    public List<CommentDto> getAllComments() {
        return commentService.getAllComments().stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
        Comment comment = commentService.createComment(commentDto);
        return ResponseEntity.ok(commentMapper.toDto(comment));
    }

}
