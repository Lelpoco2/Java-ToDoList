# JAVA ToDoList Application

### Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Java Programming Concepts Used](#java-programming-concepts-used)

## Introduction
This is a simple command-line To-Do List application written in Java. It allows users to manage their tasks by adding, viewing, marking as completed, and deleting tasks. The application also supports saving and loading tasks from a JSON file.

## Features
- Add new tasks with a title and description.
- View all tasks, pending tasks, or completed tasks.
- Mark tasks as completed.
- Delete tasks.
- Save tasks to a JSON file.
- Load tasks from a JSON file.

## Installation

1. Ensure you have Java installed on your machine (Java 8 or higher).

2. Clone this repository or download the source code.

3. Navigate to the project directory in your terminal.

4. Execute `maven clean install` to build the project and resolve dependencies.


## Usage

1. Run the `Main` class to start the application.

2. Follow the on-screen menu to interact with the To-Do List application.

## Java Programming Concepts Used

- **Classes and Objects**: The application is structured using classes such as `Task`, `ToDoList`, and `Main`. Each class encapsulates related data and behavior.

- **Encapsulation**: The `Task` class uses private fields and public getter/setter methods to encapsulate task properties.

- **Collections**: The `ToDoList` class uses an `ArrayList` to store and manage a list of tasks.

- **File I/O**: The application reads from and writes to a JSON file to persist tasks using Java's file handling capabilities.

- **Exception Handling**: The application includes basic exception handling to manage potential errors during file operations.

- **User Input**: The `Scanner` class is used to capture user input from the command line.

- **Control Structures**: The application uses loops and conditional statements to navigate the menu and perform actions based on user choices.

- **Date and Time API**: The `LocalDateTime` class is used to manage task creation timestamps.

- **JSON Processing**: The application uses the Jackson library to serialize and deserialize tasks to and from JSON format.

- **Modularization**: The code is organized into separate classes and methods to enhance readability and maintainability.

