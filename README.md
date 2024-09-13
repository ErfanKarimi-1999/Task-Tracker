## 🎯 Overview

A simple, lightweight Task Tracker application implemented in Java with a Command Line Interface (CLI). The project is
designed to help users manage and track their tasks, offering features like adding, updating, viewing, and deleting
tasks, all while storing data in a JSON file, ensuring your tasks are saved between sessions.

## ✨ Features

- **Task Management:** Add, update, and delete tasks easily
- **Task Listing:** List all tasks, with options to filter by status
- **Task Status Management:** Mark tasks with statuses: in-progress and done
- **Command Line Interface** Accepts commands and arguments for various operations

## 🚀 How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/ErfanKarimi-1999/Task-Tracker.git
    cd Task-Tracker
    ```

2. Compile
    ```bash
    mvn compile
    ```
3. Run
    ```bash
    mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='<command> [arguments]'
    ```

## 📘 Usage Example

```bash
# Adding a new task
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='add "Buy groceries"'

# Updating and deleting tasks
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='update 1 "Buy groceries and cook dinner"'
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='delete 1'

# Marking a task as in progress or done
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='mark-in-progress 1'
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='mark-done 1'

# Listing all tasks
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='list'

# Listing tasks by status
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='list done'
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='list todo'
mvn exec:java -Dexec.mainClass=com.karimi.erfan.App -Dexec.args='list in-progress'
```

Sample solution for the [Task Tracker](https://roadmap.sh/projects/task-tracker) challenge
from [roadmap.sh](https://roadmap.sh/).