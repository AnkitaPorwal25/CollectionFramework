package UniversityCourseRegisterationCollection;

import UniversityCourseRegisterationCollection.model.Course;
import UniversityCourseRegisterationCollection.model.Student;
import UniversityCourseRegisterationCollection.service.RegisterationSystem;

public class Main {
    public static void main(String[] args) {
        RegisterationSystem system = new RegisterationSystem();

        Student s1 = new Student("S101", "Alice", "alice@uni.edu", "2", "CS");
        Student s2 = new Student("S102", "Bob", "bob@uni.edu", "3", "ECE");
        Student s3 = new Student("S103", "Charlie", "charlie@uni.edu", "2", "CS");

        Course c1 = new Course("CSE101", "Data Structures", "Dr. Smith", 2, 4);
        Course c2 = new Course("ECE201", "Signals", "Dr. Ray", 1, 3);

        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);

        system.addCourse(c1);
        system.addCourse(c2);

        system.register("S101", "CSE101");
        system.register("S102", "CSE101");
        system.register("S103", "CSE101"); // Waitlisted

        system.listStudentsInCourse("CSE101");
        system.drop("S101", "CSE101"); // Promote Charlie
        system.listStudentsInCourse("CSE101");

        system.listCoursesSortedByEnrollment();
        system.filterCoursesByCredits(4);
    }
}
