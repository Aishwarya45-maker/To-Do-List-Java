import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskManager manager = new TaskManager();

        // Load saved tasks
        manager.setTasks(FileManager.loadTasks());

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("         TASK MANAGER");
            System.out.println("==================================");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. Search Task");
            System.out.println("7. Show Pending Tasks");
            System.out.println("8. Show Completed Tasks");
            System.out.println("9. Save Tasks");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Task Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Priority (HIGH/MEDIUM/LOW): ");
                    String priority = sc.nextLine().toUpperCase();

                    manager.addTask(title, priority);

                    break;

                case 2:

                    manager.viewTasks();

                    break;

                case 3:

                    manager.viewTasks();

                    System.out.print("\nEnter Task Number: ");
                    int editNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Priority (HIGH/MEDIUM/LOW): ");
                    String newPriority = sc.nextLine().toUpperCase();

                    manager.editTask(editNumber, newTitle, newPriority);

                    break;

                case 4:

                    manager.viewTasks();

                    System.out.print("\nEnter Task Number to Delete: ");
                    int deleteNumber = sc.nextInt();

                    manager.deleteTask(deleteNumber);

                    break;

                case 5:

                    manager.viewTasks();

                    System.out.print("\nEnter Task Number to Mark Completed: ");
                    int completedNumber = sc.nextInt();

                    manager.markCompleted(completedNumber);

                    break;

                case 6:

                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();

                    manager.searchTask(keyword);

                    break;

                case 7:

                    manager.showPendingTasks();

                    break;

                case 8:

                    manager.showCompletedTasks();

                    break;

                case 9:

                    FileManager.saveTasks(manager.getTasks());

                    break;

                case 10:

                    FileManager.saveTasks(manager.getTasks());

                    System.out.println("\nThank you for using Task Manager!");

                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        } while (choice != 10);

        sc.close();

    }

}