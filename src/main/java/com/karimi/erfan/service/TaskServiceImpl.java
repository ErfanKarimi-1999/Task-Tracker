package com.karimi.erfan.service;

import com.karimi.erfan.model.Task;
import com.karimi.erfan.model.TaskStatus;
import com.karimi.erfan.repository.TaskRepository;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
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
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            task.setId(1L);
        } else {
            Long last_id = tasks.getLast().getId();
            task.setId(last_id + 1);
        }
        tasks.add(task);
        taskRepository.saveAll(tasks);
    }

    @Override
    public void update(Long id, String description) {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setDescription(description);
                taskRepository.saveAll(tasks);
                return;
            }
        }
    }

    @Override
    public void delete(Long id) {
        List<Task> tasks = taskRepository.findAll();
        tasks.removeIf(task -> task.getId().equals(id));
        taskRepository.saveAll(tasks);
    }

    @Override
    public void mark(Long id, TaskStatus taskStatus) {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(taskStatus);
                taskRepository.saveAll(tasks);
                return;
            }
        }
    }
}
