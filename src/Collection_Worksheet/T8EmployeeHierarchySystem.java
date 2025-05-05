package Collection_Worksheet;
import java.util.*;

class Employeee {
    private String name;
    private int id;

    public Employeee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}

class Manager {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Level {
    JUNIOR, MID, SENIOR, LEAD
}

public class T8EmployeeHierarchySystem {

    public static void main(String[] args) {
        // Map to hold Manager -> TreeMap of Level -> List of Employees
        Map<Manager, TreeMap<Level, List<Employeee>>> hierarchy = new HashMap<>();

        // Creating some Managers
        Manager manager1 = new Manager("Alice");
        Manager manager2 = new Manager("Bob");

        // Creating Employees
        Employeee emp1 = new Employeee("John", 101);
        Employeee emp2 = new Employeee("Jane", 102);
        Employeee emp3 = new Employeee("Tom", 103);
        Employeee emp4 = new Employeee("Emily", 104);
        Employeee emp5 = new Employeee("Michael", 105);

        // Add employees to different levels under managers
        addEmployeeToManager(hierarchy, manager1, Level.JUNIOR, emp1);
        addEmployeeToManager(hierarchy, manager1, Level.MID, emp2);
        addEmployeeToManager(hierarchy, manager1, Level.SENIOR, emp3);

        addEmployeeToManager(hierarchy, manager2, Level.MID, emp4);
        addEmployeeToManager(hierarchy, manager2, Level.LEAD, emp5);

        // Print hierarchy
        printHierarchy(hierarchy);
    }

    // Method to add an employee under a specific manager and level
    private static void addEmployeeToManager(Map<Manager, TreeMap<Level, List<Employeee>>> hierarchy, Manager manager, Level level, Employeee employee) {
        hierarchy.computeIfAbsent(manager, k -> new TreeMap<>())
                .computeIfAbsent(level, k -> new ArrayList<>())
                .add(employee);
    }

    // Method to print the employee hierarchy
    private static void printHierarchy(Map<Manager, TreeMap<Level, List<Employeee>>> hierarchy) {
        for (Map.Entry<Manager, TreeMap<Level, List<Employeee>>> entry : hierarchy.entrySet()) {
            Manager manager = entry.getKey();
            TreeMap<Level, List<Employeee>> levels = entry.getValue();

            System.out.println("\nManager: " + manager.getName());

            for (Map.Entry<Level, List<Employeee>> levelEntry : levels.entrySet()) {
                Level level = levelEntry.getKey();
                List<Employeee> employees = levelEntry.getValue();

                System.out.println("  Level: " + level);
                for (Employeee employee : employees) {
                    System.out.println("    " + employee);
                }
            }
        }
    }
}
