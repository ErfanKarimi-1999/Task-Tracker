package com.karimi.erfan.service;

import com.karimi.erfan.model.Task;
import com.karimi.erfan.model.TaskStatus;
import com.karimi.erfan.repository.TaskRepository;
import com.karimi.erfan.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskRepositoryImpl taskRepository;

    public TaskServiceImpl(TaskRepositoryImpl taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findAllByStatus(TaskStatus taskStatus) {
        return taskRepository.findAllByStatus(taskStatus);
    }

    @Override
    public void add(Task task) {
        if (taskRepository.getTaskDataAccess().getTasks().isEmpty()) {
            task.setId(1L);
        } else {
            Long last_id = taskRepository.getTaskDataAccess().getTasks().last().getId();
            task.setId(last_id + 1);
        }
        taskRepository.getTaskDataAccess().getTasks().add(task);
        taskRepository.saveAll();
    }

    @Override
    public void update(Long id, String description) {
        for (Task task : taskRepository.getTaskDataAccess().getTasks()) {
            if (task.getId().equals(id)) {
                task.setDescription(description);
                taskRepository.saveAll();
                return;
            }
        }
    }

    @Override
    public void delete(Long id) {
        taskRepository.getTaskDataAccess().getTasks().removeIf(task -> task.getId().equals(id));
        taskRepository.saveAll();
    }

    @Override
    public void mark(Long id, TaskStatus taskStatus) {
        for (Task task : taskRepository.getTaskDataAccess().getTasks()) {
            if (task.getId().equals(id)) {
                task.setStatus(taskStatus);
                taskRepository.saveAll();
                return;
            }
        }
    }
}
