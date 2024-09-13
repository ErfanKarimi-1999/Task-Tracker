package com.karimi.erfan.cli;

import com.karimi.erfan.model.Task;
import com.karimi.erfan.model.TaskStatus;
import com.karimi.erfan.service.TaskService;

public class CommandLineHandler {
    private final TaskService taskService;

    public CommandLineHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public void start(String[] commandLineArguments) {
        switch (commandLineArguments[0]) {
            case "add" -> addTask(commandLineArguments[1]);
            case "update" -> updateTask(Long.parseLong(commandLineArguments[1]), commandLineArguments[2]);
            case "delete" -> deleteTask(Long.parseLong(commandLineArguments[1]));
            case "mark-in-progress" -> markTask(Long.parseLong(commandLineArguments[1]), TaskStatus.IN_PROGRESS);
            case "mark-done" -> markTask(Long.parseLong(commandLineArguments[1]), TaskStatus.DONE);
            case "list" -> {
                if (commandLineArguments.length == 1) {
                    listTasks();
                } else {
                    switch (commandLineArguments[1]) {
                        case "done" -> listTasksByStatus(TaskStatus.DONE);
                        case "todo" -> listTasksByStatus(TaskStatus.TODO);
                        case "in-progress" -> listTasksByStatus(TaskStatus.IN_PROGRESS);
                    }
                }
            }
        }
    }

    private void addTask(String description) {
        taskService.add(new Task(description));
    }

    private void updateTask(Long id, String description) {
        taskService.update(id, description);
    }

    private void deleteTask(Long id) {
        taskService.delete(id);
    }

    private void markTask(Long id, TaskStatus taskStatus) {
        taskService.mark(id, taskStatus);
    }

    private void listTasks() {
        System.out.println(taskService.findAll());
    }

    private void listTasksByStatus(TaskStatus taskStatus) {
        System.out.println(taskService.findAllByStatus(taskStatus));
    }
}