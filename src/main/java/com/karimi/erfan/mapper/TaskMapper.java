package com.karimi.erfan.mapper;

import com.karimi.erfan.model.Task;
import com.karimi.erfan.model.TaskStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    private String jsonPropertyValue(String jsonProperty) {
        return jsonProperty.substring(jsonProperty.indexOf(':') + 1)
                .replace("\"", "")
                .replace(",", "")
                .stripLeading();
    }

    public Task jsonToTask(List<String> jsonProperties) {
        Task task = new Task();
        String lineValue = jsonPropertyValue(jsonProperties.get(0));
        task.setId(Long.parseLong(lineValue));
        lineValue = jsonPropertyValue(jsonProperties.get(1));
        task.setDescription(lineValue);
        lineValue = jsonPropertyValue(jsonProperties.get(2));
        task.setStatus(TaskStatus.getEnumByLabel(lineValue));
        lineValue = jsonPropertyValue(jsonProperties.get(3));
        task.setCreatedAt(LocalDateTime.parse(lineValue));
        lineValue = jsonPropertyValue(jsonProperties.get(4));
        task.setUpdatedAt(LocalDateTime.parse(lineValue));
        return task;
    }

    public String taskToJson(Task task) {
        return "    {\n" +
                "      \"id\": " + task.getId() + ",\n" +
                "      \"description\": \"" + task.getDescription() + "\",\n" +
                "      \"status\": \"" + task.getStatus().label + "\",\n" +
                "      \"createdAt\": \"" + task.getCreatedAt().toString() + "\",\n" +
                "      \"updatedAt\": \"" + task.getUpdatedAt().toString() + "\"\n" +
                "    },\n";
    }

    public String tasksToJson(List<Task> tasks) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");
        jsonBuilder.append("  \"tasks\": [\n");
        for (Task task : tasks)
            jsonBuilder.append(taskToJson(task));
        jsonBuilder.deleteCharAt(jsonBuilder.length() - 2);
        jsonBuilder.append("  ]\n");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}