package Collection_Worksheet;

import java.util.*;
import java.util.stream.Collectors;
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
    }
}


public class T3DepartmentDirectory {
    private Map<String, List<Employee>> departmentMap;

    public T3DepartmentDirectory() {
        departmentMap = new HashMap<>();
    }

    // Add employee to department
    public void addEmployee(String department, Employee employee) {
        departmentMap.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
    }

    // Sort employees in each department by salary descending
    public void sortDepartmentsBySalary() {
        for (List<Employee> employees : departmentMap.values()) {
            employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        }
    }



    // Get top N paid employees across all departments
    public List<Employee> getTopPaidEmployees(int n) {
        return departmentMap.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    // For displaying department-wise
    public void printDepartmentDirectory() {
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            System.out.println("\nDepartment: " + entry.getKey());
            for (Employee e : entry.getValue()) {
                System.out.println(e);
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        T3DepartmentDirectory directory = new T3DepartmentDirectory();

        // Adding employees
        directory.addEmployee("HR", new Employee(1, "Alice", 50000));
        directory.addEmployee("HR", new Employee(2, "Bob", 60000));
        directory.addEmployee("IT", new Employee(3, "Charlie", 90000));
        directory.addEmployee("IT", new Employee(4, "David", 85000));
        directory.addEmployee("Finance", new Employee(5, "Eva", 75000));
        directory.addEmployee("Finance", new Employee(6, "Frank", 72000));
        directory.addEmployee("IT", new Employee(7, "George", 95000));

        // Sort departments internally
        directory.sortDepartmentsBySalary();

        // Print department-wise sorted employee list
        directory.printDepartmentDirectory();

        // Get top 3 paid employees overall
        System.out.println("\nTop 3 Paid Employees:");
        List<Employee> topEmployees = directory.getTopPaidEmployees(3);
        for (Employee e : topEmployees) {
            System.out.println(e);
        }
    }
}









//For efficiency in sorting employees by salary and top N retrieval: TreeMap(for storing Keys on basis of some order) + PriorityQueue(for storing and retrieving top n users or something like this) is the best choice, despite its complexity and higher memory usage.
// for faster lookups use Hashset + list

