package com.karimi.erfan.repository;

import com.karimi.erfan.model.Task;
import com.karimi.erfan.model.TaskStatus;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();

    List<Task> findAllByStatus(TaskStatus taskStatus);

    void saveAll();
}
