package com.karimi.erfan.service;

import com.karimi.erfan.model.Task;
import com.karimi.erfan.model.TaskStatus;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    List<Task> findAllByStatus(TaskStatus taskStatus);

    void add(Task task);

    void update(Long id, String description);

    void delete(Long id);

    void mark(Long id, TaskStatus taskStatus);
}
