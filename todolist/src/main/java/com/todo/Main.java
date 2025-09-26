package com.todo;

import java.util.Scanner;

import com.todo.Task;
import com.todo.ToDoList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean condition = true;
        Task task = null;
        ToDoList todoList = new ToDoList();

        System.out.println("Welcome to your To-Do List application!\n\n");

        String menu = """
        -------------------------------------
        Choose one of the following options:
        
        1. Add a new task               2. View all tasks
        3. Mark a task as completed     4. Remove a task
        5. Show completed tasks         6. Delete completed tasks
        7. Delete all tasks             8. Show pending tasks
        9. Exit
        """;

                
                
                
            do {
                System.out.print(menu);
                
                System.out.print("\nInsert your choice [1-5]: ");
                int choice = scanner.nextInt();
            
            
            switch (choice) {
                //add task
                case 1:
                    System.out.println("Adding a new task!\n");
                    // Consume leftover newline
                    scanner.nextLine();
                    
                    System.out.println("Insert the task's title:");
                    String title = scanner.nextLine();
                    
                    System.out.println("Insert the task's description:");
                    String description = scanner.nextLine();
                    
                    Task newTask = new Task(title, description);
                    
                    todoList.addTask(newTask);
                    
                    System.out.println("Task added successfully!\n");
                    break;
                

                // View all tasks
                case 2: 
                    System.out.println("\nViewing all tasks:\n");
                    List<Task> tasks = todoList.getTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.\n");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.printf("%d.\n%s\n\n", i + 1, tasks.get(i).toString());
                        }
                        System.out.println();

                    }
                    break;

                // Mark a task as completed showing the pending tasks only
                case 3:

                    List<Task> taskToComplete = todoList.getPendingTasks();
                    if (taskToComplete.isEmpty()) {
                        System.out.println("No pending tasks available to mark as completed.\n");
                        break;}
                    
                    else {
                        System.out.println("Select the task to mark as completed by number (only titles shown):");
                        for (int i = 0; i < taskToComplete.size(); i++) {
                            System.out.printf("%d. %s\n\n", i + 1, taskToComplete.get(i).getTitle());
                        }
                        System.out.print("Choice: ");
                        int taskNumber = scanner.nextInt();
                        boolean marked = todoList.markTaskCompleted(taskNumber - 1);
                        if (marked) {
                            System.out.println("\nTask marked as completed successfully!\n");
                        } else {
                            System.out.println("\nInvalid task number. No task marked as completed.\n");
                        }
                    }

                    break;


                // Remove a task
                case 4:
                    List<Task> tasksToDelete = todoList.getTasks();
                    if (tasksToDelete.isEmpty()) {
                        System.out.println("No tasks available to remove.\n");
                        break;
                    }
                    System.out.println("Select the task to remove by number (only titles shown):");
                    for (int i = 0; i < tasksToDelete.size(); i++) {
                        System.out.printf("%d. %s\n\n", i + 1, tasksToDelete.get(i).getTitle());
                    }
                    System.out.print("Choice: ");
                    int taskNumber = scanner.nextInt();
                    boolean removed = todoList.removeTask(taskNumber - 1);
                    if (removed) {
                        System.out.println("\nTask removed successfully!\n");
                    } else {
                        System.out.println("\nInvalid task number. No task removed.\n");
                    }
                    break;
                
                // Show completed tasks
                case 5:
                    List<Task> completedTasks = todoList.getComplitedTasks();
                    if (completedTasks.isEmpty()) {
                        System.out.println("No completed tasks available.\n");
                    }
                    if (!completedTasks.isEmpty()) {
                        System.out.println("\nViewing completed tasks:\n");
                        for (int i = 0; i < completedTasks.size(); i++) {
                            System.out.printf("%d.\n%s\n\n", i + 1, completedTasks.get(i).toString());
                        }
                        System.out.println();
                    }
                    break;
                
                // Delete completed tasks
                case 6:
                    List<Task> completedTasksToDelete = todoList.getComplitedTasks();
                    if (completedTasksToDelete.isEmpty()) {
                        System.out.println("No completed tasks available.\n");
                    }
                    if (!completedTasksToDelete.isEmpty()) {
                        for (int i = 0; i < completedTasksToDelete.size(); i++) {
                            todoList.removeTask(todoList.getTasks().indexOf(completedTasksToDelete.get(i)));
                        }
                        System.out.println("All completed tasks have been deleted successfully!\n");
                    }
                    break;
                    
                // Delete all tasks
                case 7:
                    if (todoList.size() == 0) {
                        System.out.println("No tasks available to delete.\n");
                    } else {
                        for (int i = todoList.size() - 1; i >= 0; i--) {
                            todoList.removeTask(i);
                        }
                        System.out.println("All tasks have been deleted successfully!\n");
                    }
                    break;
                
                // Show pending tasks
                case 8:
                    List<Task> pendingTasks = todoList.getPendingTasks();
                    if (pendingTasks.isEmpty()) {
                        System.out.println("No pending tasks available.\n");
                    } else {
                        System.out.println("\nViewing pending tasks:\n");
                        for (int i = 0; i < pendingTasks.size(); i++) {
                            System.out.printf("%d.\n%s\n\n", i + 1, pendingTasks.get(i).toString());
                        }
                        System.out.println();
                    }
                    break;
                
                case 9:
                    System.out.println("Exiting the application. Goodbye!");
                    condition = false;
                    break;
                
                default: 
                    System.out.println("Invalid choice. Please try again.");
                break;
            }


        } while (condition == true);
    }
}