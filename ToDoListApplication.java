import java.util.*;

public class ToDoListApplication {
    static Scanner scanner = new Scanner(System.in);
    static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskAsCompleted();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully.");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nTasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.description + " [" + (task.isCompleted ? "Completed" : "Pending") + "]");
            }
        }
    }

    static void markTaskAsCompleted() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark as completed: ");
        int taskNumber;
        try {
            taskNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid task number.");
            return;
        }

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number. Please try again.");
        } else {
            tasks.get(taskNumber - 1).isCompleted = true;
            System.out.println("Task marked as completed.");
        }
    }

    static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int taskNumber;
        try {
            taskNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid task number.");
            return;
        }

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number. Please try again.");
        } else {
            tasks.remove(taskNumber - 1);
            System.out.println("Task deleted successfully.");
        }
    }
}

class Task {
    String description;
    boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
}
