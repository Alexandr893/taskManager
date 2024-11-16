package org.example.taskmanager.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.taskmanager.enums.Priority;
import org.example.taskmanager.enums.Status;

import java.util.Set;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @OneToMany(mappedBy = "task")
    private Set<Comment> comments;

    // Getters и Setters

}
