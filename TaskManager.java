import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    // Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add Task
    public void addTask(String title, String priority) {
        Task task = new Task(title, priority);
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    // View All Tasks
    public void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks available.");
            return;
        }

        System.out.println("\n========== ALL TASKS ==========");

        for (int i = 0; i < tasks.size(); i++) {

            System.out.println("\nTask #" + (i + 1));
            System.out.println(tasks.get(i));
            System.out.println("-------------------------------");

        }
    }

    // Edit Task
    public void editTask(int taskNumber, String newTitle, String newPriority) {

        if (!isValidTask(taskNumber))
            return;

        Task task = tasks.get(taskNumber - 1);

        task.setTitle(newTitle);
        task.setPriority(newPriority);

        System.out.println("Task updated successfully.");
    }

    // Delete Task
    public void deleteTask(int taskNumber) {

        if (!isValidTask(taskNumber))
            return;

        Task removedTask = tasks.remove(taskNumber - 1);

        System.out.println("🗑 Removed: " + removedTask.getTitle());
    }

    // Mark Completed
    public void markCompleted(int taskNumber) {

        if (!isValidTask(taskNumber))
            return;

        Task task = tasks.get(taskNumber - 1);
        task.setCompleted(true);

        System.out.println("Task marked as completed.");
    }

    // Search Task
    public void searchTask(String keyword) {

        boolean found = false;

        for (Task task : tasks) {

            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(task);
                System.out.println("-------------------------------");
                found = true;

            }

        }

        if (!found) {
            System.out.println("No matching task found.");
        }
    }

    // Show Pending Tasks
    public void showPendingTasks() {

        boolean found = false;

        for (Task task : tasks) {

            if (!task.isCompleted()) {

                System.out.println(task);
                System.out.println("-------------------------------");
                found = true;

            }

        }

        if (!found) {
            System.out.println("No pending tasks.");
        }
    }

    // Show Completed Tasks
    public void showCompletedTasks() {

        boolean found = false;

        for (Task task : tasks) {

            if (task.isCompleted()) {

                System.out.println(task);
                System.out.println("-------------------------------");
                found = true;

            }

        }

        if (!found) {
            System.out.println("No completed tasks.");
        }
    }

    // Return all tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Replace task list (used while loading from file)
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // Validate task number
    private boolean isValidTask(int taskNumber) {

        if (taskNumber < 1 || taskNumber > tasks.size()) {

            System.out.println("Invalid task number.");
            return false;

        }

        return true;
    }
}