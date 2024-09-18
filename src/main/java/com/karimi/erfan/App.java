package com.karimi.erfan;

import com.karimi.erfan.cli.CommandLineHandler;
import com.karimi.erfan.helper.JsonFileHandler;
import com.karimi.erfan.repository.TaskRepositoryImpl;
import com.karimi.erfan.service.TaskService;
import com.karimi.erfan.service.TaskServiceImpl;

public class App {
    public static void main(String[] args) {
        String filePath = "./src/main/resources/tasks.json";
        JsonFileHandler jsonFileHandler = new JsonFileHandler(filePath);
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(jsonFileHandler);
        TaskService taskService = new TaskServiceImpl(taskRepository);
        CommandLineHandler commandLineHandler = new CommandLineHandler(taskService);
        commandLineHandler.start(args);
    }
}
