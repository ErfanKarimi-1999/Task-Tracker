package com.karimi.erfan.repository;

import com.karimi.erfan.helper.JsonFileHandler;
import com.karimi.erfan.mapper.TaskMapper;
import com.karimi.erfan.model.Task;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class TaskDataAccess {
    private final JsonFileHandler jsonFileHandler;
    private final SortedSet<Task> tasks;
    private final TaskMapper taskMapper;

    public TaskDataAccess(JsonFileHandler jsonFileHandler) {
        this.jsonFileHandler = jsonFileHandler;
        tasks = new TreeSet<>(findAll());
        taskMapper = new TaskMapper();
    }

    public SortedSet<Task> getTasks() {
        return tasks;
    }

    private List<Task> findAll() {
        return new TaskMapper().jsonToTasks(jsonFileHandler.readAllLines());
    }

    public void saveAll() {
        if (tasks.isEmpty()) {
            jsonFileHandler.writeJsonToFile("");
        } else {
            jsonFileHandler.writeJsonToFile(taskMapper.tasksToJson(tasks));
        }
    }
}
