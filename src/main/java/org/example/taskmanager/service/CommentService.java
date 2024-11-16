package org.example.taskmanager.service;

import lombok.AllArgsConstructor;
import org.example.taskmanager.dao.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;




}
