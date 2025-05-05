package Collection_Worksheet;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;

class Task {
    private String name;
    private int priority; // Higher number = higher priority
    private LocalDate deadline;

    public Task(String name, int priority, LocalDate deadline) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getName() { return name; }
    public int getPriority() { return priority; }
    public LocalDate getDeadline() { return deadline; }

    @Override
    public String toString() {
        return String.format("Task{name='%s', priority=%d, deadline=%s}", name, priority, deadline);
    }
}

public class T4TaskPrioritizationEngine {
    public static void main(String[] args) {
        // Define custom comparator: deadline ASC, then priority DESC
        Comparator<Task> taskComparator = Comparator
                .comparing(Task::getDeadline)
                .thenComparing(Comparator.comparing(Task::getPriority).reversed());

        // Create priority queue with custom comparator
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(taskComparator);

        // Add tasks
        taskQueue.add(new Task("Submit Report", 3, LocalDate.of(2025, 5, 1)));
        taskQueue.add(new Task("Pay Bills", 5, LocalDate.of(2025, 4, 30)));
        taskQueue.add(new Task("Team Meeting", 2, LocalDate.of(2025, 4, 30)));
        taskQueue.add(new Task("Doctor Appointment", 4, LocalDate.of(2025, 5, 2)));
        taskQueue.add(new Task("Project Launch", 5, LocalDate.of(2025, 5, 1)));

        // Poll and print tasks in order of execution
        System.out.println("Tasks to execute in order:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}