import java.time.LocalDate;

public class Task {

    private String title;
    private String priority;
    private boolean completed;
    private LocalDate createdDate;

    // Constructor for new task
    public Task(String title, String priority) {
        this.title = title;
        this.priority = priority;
        this.completed = false;
        this.createdDate = LocalDate.now();
    }

    // Constructor for loading from file
    public Task(String title, String priority, boolean completed, LocalDate createdDate) {
        this.title = title;
        this.priority = priority;
        this.completed = completed;
        this.createdDate = createdDate;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {

        String status = completed ? "Completed ✅" : "Pending ❌";

        return "Title      : " + title +
                "\nPriority  : " + priority +
                "\nStatus    : " + status +
                "\nCreated   : " + createdDate;
    }
}