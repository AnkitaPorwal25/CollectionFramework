package Collection_Worksheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T15CollegeSubjectAllotment {
    // Map from student name -> list of subjects
    private Map<String, List<String>> studentSubjects = new HashMap<>();

    // Add a subject to a student
    public void allotSubject(String student, String subject) {
        studentSubjects.computeIfAbsent(student, k -> new ArrayList<>()).add(subject);
        System.out.println("Allotted " + subject + " to " + student);
    }

    // Show all subjects of a student
    public void showSubjectsForStudent(String student) {
        List<String> subjects = studentSubjects.get(student);
        if (subjects == null || subjects.isEmpty()) {
            System.out.println(student + " has no subjects allotted.");
        } else {
            System.out.println(student + " is enrolled in: " + subjects);
        }
    }

    // Reverse lookup: show all students enrolled in a subject
    public void showStudentsForSubject(String subject) {
        List<String> students = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            if (entry.getValue().contains(subject)) {
                students.add(entry.getKey());
            }
        }

        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + subject);
        } else {
            System.out.println("Students enrolled in " + subject + ": " + students);
        }
    }

    // Show all data
    public void showAllAllotments() {
        System.out.println("All Allotments:");
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        T15CollegeSubjectAllotment system = new T15CollegeSubjectAllotment();

        // Sample subject allotments
        system.allotSubject("Alice", "Math");
        system.allotSubject("Alice", "Physics");
        system.allotSubject("Bob", "Math");
        system.allotSubject("Charlie", "Chemistry");

        // Display information
        system.showSubjectsForStudent("Alice");
        system.showStudentsForSubject("Math");
        system.showStudentsForSubject("Biology");
        system.showAllAllotments();
    }
}
