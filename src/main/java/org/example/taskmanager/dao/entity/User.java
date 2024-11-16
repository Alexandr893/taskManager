package org.example.taskmanager.dao.entity;

import jakarta.persistence.*;
import org.example.taskmanager.enums.Role;


import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author")
    private Set<Task> createdTasks;

    @OneToMany(mappedBy = "assignee")
    private Set<Task> assignedTasks;
}

