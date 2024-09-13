## 🎯 Overview

A simple, lightweight Task Tracker application implemented in Java with a Command Line Interface (CLI). The project is
designed to help users manage and track their tasks, offering features like adding, updating, viewing, and deleting
tasks, all while storing data in a JSON file, ensuring your tasks are saved between sessions.

## ✨ Features

- **Task Management:**
    - Add, update, and delete tasks easily via a command-line interface (CLI)
- **Task Status Management:**
    - Mark tasks with various statuses: in-progress, and done
    - Retrieve tasks based on their statuses
- **Task Listing:**
    - List all tasks, with options to filter by status
- **JSON Data Storage:**
    - Store tasks in a tasks.json file, allowing for persistent data management
    - Automatically create the JSON file if it does not exist
- **Command-Line Interface**
    - Accepts commands and arguments for various operations
- **Error Handling**
    - Graceful handling of errors and edge cases
- **Easy Setup**
    - Simple setup process requiring only Java and no external libraries, making it easy to run in any Java environment
- **Modular Architecture**
    - Organized project structure with clear separation of concerns (models, services, repositories, and CLI)
- **Unit Testing**
    - Includes unit tests for the core functionalities, ensuring reliability and maintaining code quality

## 🚀 How to Run

1. Clone the repository:
    ```bash
    git https://github.com/ErfanKarimi-1999/Task-Tracker.git
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