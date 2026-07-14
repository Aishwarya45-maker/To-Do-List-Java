import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "tasks.txt";

    // Save tasks to file
    public static void saveTasks(ArrayList<Task> taskList) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Task task : taskList) {

                writer.write(task.getTitle() + "|"
                        + task.getPriority() + "|"
                        + task.isCompleted() + "|"
                        + task.getCreatedDate());

                writer.newLine();
            }

            System.out.println("Tasks saved successfully.");

        } catch (IOException e) {
            System.out.println("Unable to save tasks.");
        }
    }

    // Load tasks from file
    public static ArrayList<Task> loadTasks() {

        ArrayList<Task> taskList = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return taskList;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    String title = data[0];
                    String priority = data[1];
                    boolean completed = Boolean.parseBoolean(data[2]);
                    LocalDate createdDate = LocalDate.parse(data[3]);

                    Task task = new Task(title, priority, completed, createdDate);

                    taskList.add(task);
                }
            }

        } catch (IOException e) {
            System.out.println("Unable to load tasks.");
        }

        return taskList;
    }

}