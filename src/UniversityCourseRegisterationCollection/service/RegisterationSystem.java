package UniversityCourseRegisterationCollection.service;

import UniversityCourseRegisterationCollection.model.Course;
import UniversityCourseRegisterationCollection.model.Student;

import java.util.HashMap;
import java.util.Map;

public class RegisterationSystem {
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();

    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public boolean register(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student == null || course == null) return false;
        return course.enrollStudent(student);
    }

    public boolean drop(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student == null || course == null) return false;
        return course.dropStudent(student);
    }

    public void listStudentsInCourse(String courseId) {
        Course course = courses.get(courseId);
        if (course == null) return;
        System.out.println("Students in " + course + ":");
        course.getEnrolledStudents().forEach(System.out::println);
    }

    public void listStudentsByBranch(String branch) {
        System.out.println("Students from branch " + branch + ":");
        students.values().stream()
                .filter(s -> s.getBranch().equalsIgnoreCase(branch))
                .forEach(System.out::println);
    }

    public void listCoursesSortedByEnrollment() {
        courses.values().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getEnrolledCount(), c1.getEnrolledCount()))
                .forEach(c -> System.out.println(c + ": " + c.getEnrolledCount() + " students"));
    }

    public void filterCoursesByCredits(int credits) {
        courses.values().stream()
                .filter(c -> c.getCredits() == credits)
                .forEach(System.out::println);
    }

    public void filterCoursesByInstructor(String instructor) {
        courses.values().stream()
                .filter(c -> c.getInstructorName().equalsIgnoreCase(instructor))
                .forEach(System.out::println);
    }
}
