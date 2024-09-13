package com.karimi.erfan.repository;

import com.karimi.erfan.helper.JsonFileHandler;
import com.karimi.erfan.mapper.TaskMapper;
import com.karimi.erfan.model.Task;
import com.karimi.erfan.model.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final JsonFileHandler jsonFileHandler;
    private final List<String> jsonFileLines;
    private final TaskMapper taskMapper;

    public TaskRepositoryImpl(JsonFileHandler jsonFileHandler) {
        this.jsonFileLines = jsonFileHandler.readAllLines();
        this.jsonFileHandler = jsonFileHandler;
        this.taskMapper = new TaskMapper();
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < jsonFileLines.size(); i++) {
            if (jsonFileLines.get(i).equals("    {")) {
                tasks.add(taskMapper.jsonToTask(jsonFileLines.subList(i + 1, i + 6)));
            }
        }
        return tasks;
    }

    @Override
    public List<Task> findAllByStatus(TaskStatus taskStatus) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < jsonFileLines.size(); i++) {
            if (jsonFileLines.get(i).equals("    {")) {
                if (jsonFileLines.get(i + 3).contains(taskStatus.label)) {
                    tasks.add(taskMapper.jsonToTask(jsonFileLines.subList(i + 1, i + 6)));
                }
            }
        }
        return tasks;
    }

    @Override
    public void saveAll(List<Task> tasks) {
        if (tasks.isEmpty()) {
            jsonFileHandler.writeJsonToFile("");
        } else {
            jsonFileHandler.writeJsonToFile(taskMapper.tasksToJson(tasks));
        }
    }
}