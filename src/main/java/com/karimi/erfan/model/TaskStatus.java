package com.karimi.erfan.model;

public enum TaskStatus {
    TODO("todo"),
    IN_PROGRESS("in-progress"),
    DONE("done");

    public final String label;

    TaskStatus(String label) {
        this.label = label;
    }

    public static TaskStatus getEnumByLabel(String label) {
        for (TaskStatus taskStatus : TaskStatus.values()) {
            if (taskStatus.label.equals(label))
                return taskStatus;
        }
        return null;
    }
}
