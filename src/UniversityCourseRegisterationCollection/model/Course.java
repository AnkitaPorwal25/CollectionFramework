package UniversityCourseRegisterationCollection.model;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeSet;

public class Course {
    private String courseId, courseName, instructorName;
    private int capacity, credits;
    private TreeSet<Student> enrolledStudents = new TreeSet<>();
    private Queue<Student> waitlist = new LinkedList<>();

    public Course(String courseId, String courseName, String instructorName, int capacity, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.capacity = capacity;
        this.credits = credits;
    }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.contains(student)) return false;
        if (enrolledStudents.size() < capacity) {
            return enrolledStudents.add(student);
        } else {
            if (!waitlist.contains(student)) {
                waitlist.offer(student);
            }
            return false;
        }
    }

    public boolean dropStudent(Student student) {
        if (enrolledStudents.remove(student)) {
            promoteWaitlistedStudent();
            return true;
        }
        return waitlist.remove(student);
    }

    private void promoteWaitlistedStudent() {
        if (!waitlist.isEmpty()) {
            Student next = waitlist.poll();
            enrolledStudents.add(next);
        }
    }

    public TreeSet<Student> getEnrolledStudents() { return enrolledStudents; }
    public Queue<Student> getWaitlist() { return waitlist; }
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructorName() { return instructorName; }
    public int getCredits() { return credits; }
    public int getCapacity() { return capacity; }

    public int getEnrolledCount() { return enrolledStudents.size(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public String toString() {
        return courseName + " (" + courseId + ")";
    }
}