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

//
//
//🧑‍💻 Assignment: University Course Registration System
//📝 Objective:
//Design and implement a scalable, modular university course registration system using Java Collections Framework. The system should support course creation, student registration with waitlisting, capacity validation, and course analytics.
//Shape
//📦 Requirements
//1. Core Classes
//Student: id, name, email, year, branch
//Course: courseId, courseName, instructorName, capacity, credits, Set<Student> enrolledStudents, Queue<Student> waitlist
//RegistrationSystem: Manages courses, students, registration, waitlisting, analytics
//Shape
//2. Functionalities
//Register student to a course:
//Check if already enrolled or waitlisted
//        If full, add to waitlist
//Move waitlisted students when a spot frees up
//Drop a course:
//Remove from enrolled list
//Automatically promote next student from waitlist
//List students:
//For a specific course (sorted by name)
//For a particular branch across all courses
//List courses:
//Sorted by number of enrolled students (descending)
//Filter by credits or instructor
//        Shape
//3. Collections to Use
//HashMap<String, Course> — stores all courses by courseId
//HashMap<String, Student> — stores all students by studentId
//TreeSet<Student> — maintain sorted enrolled students per course (by name or roll number)
//Queue<Student> — waitlist using LinkedList
//List<Course> — for reporting and filtering
//Map<String, List<Course>> — group courses by instructor or branch
//Shape
//4. Additional Requirements
//Override equals() and hashCode() for Student and Course to ensure uniqueness
//Use Comparator for custom sorting (e.g., by year, branch, name)
//Prevent duplicate registrations
//Implement validation for data entry (e.g., invalid course ID or email)
//Shape
//🧪 Deliverables
//Full Java codebase with appropriate package structure (model, service, util, main)
//Modular design with separation of logic and data
//Sample console interactions for:
//Registration
//        Dropping
//Course & student listings
//README with instructions
//        Shape
//