package org.example.taskmanager.dao.repository;

import org.example.taskmanager.dao.entity.Task;
import org.example.taskmanager.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAuthor(User author);
    List<Task> findByAssignee(User assignee);
}
