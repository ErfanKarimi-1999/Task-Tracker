package com.karimi.erfan.repository;

import com.karimi.erfan.helper.JsonFileHandler;
import com.karimi.erfan.model.Task;
import com.karimi.erfan.model.TaskStatus;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final TaskDataAccess taskDataAccess;

    public TaskRepositoryImpl(JsonFileHandler jsonFileHandler) {
        taskDataAccess = new TaskDataAccess(jsonFileHandler);
    }

    public TaskDataAccess getTaskDataAccess() {
        return taskDataAccess;
    }

    @Override
    public List<Task> findAll() {
        return taskDataAccess.getTasks().stream().toList();
    }

    @Override
    public List<Task> findAllByStatus(TaskStatus taskStatus) {
        return taskDataAccess.getTasks().stream().filter(task -> task.getStatus().equals(taskStatus)).toList();
    }

    @Override
    public void saveAll() {
        taskDataAccess.saveAll();
    }
}