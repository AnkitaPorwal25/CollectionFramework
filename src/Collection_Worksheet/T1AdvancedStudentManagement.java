package Collection_Worksheet;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String name;
    private int age;
    private double grade;
    private String branch;

    public Student(int id, String name, int age, double grade, String branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.branch = branch;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
    public String getBranch() { return branch; }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', age=%d, grade=%.2f, branch='%s'}",
                id, name, age, grade, branch);
    }
}
public class T1AdvancedStudentManagement {
    public static void main(String ar[]){
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Alice", 20, 88.5, "CSE"),
                new Student(2, "Bob", 21, 75.0, "ECE"),
                new Student(3, "Charlie", 22, 92.3, "CSE"),
                new Student(4, "David", 20, 85.4, "ME"),
                new Student(5, "Eva", 23, 90.1, "CSE"),
                new Student(6, "Frank", 22, 65.2, "ECE"),
                new Student(7, "Grace", 21, 79.5, "ME"),
                new Student(8, "Hannah", 22, 91.0, "CSE"),
                new Student(9, "Ian", 20, 87.0, "ECE"),
                new Student(10, "Jack", 24, 70.5, "ME"),
                new Student(11, "Kathy", 23, 89.9, "CSE"),
                new Student(12, "Leo", 22, 82.1, "ECE"),
                new Student(13, "Mona", 21, 90.5, "ME"),
                new Student(14, "Nick", 23, 78.8, "CSE"),
                new Student(15, "Olivia", 22, 88.0, "ECE")
        ));

        // Sort students by branch, then by descending grade
        students.sort(Comparator
                .comparing(Student::getBranch)
                .thenComparing(Comparator.comparing(Student::getGrade).reversed()));

        System.out.println("Sorted Students:");
        students.forEach(System.out::println);

        // Group students by branch
        Map<String, List<Student>> groupedByBranch = students.stream()
                .collect(Collectors.groupingBy(Student::getBranch));

        System.out.println("\nGrouped Students by Branch:");
        for (Map.Entry<String, List<Student>> entry : groupedByBranch.entrySet()) {
            System.out.println("Branch: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
