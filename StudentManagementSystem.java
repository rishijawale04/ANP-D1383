// Simple Student Management System in Core Java using Collections
// Modules: Student and Attendance

import java.util.*;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

class Attendance {
    private Map<Integer, String> attendanceMap = new HashMap<>();

    public void markAttendance(int studentId, String status) {
        attendanceMap.put(studentId, status);
    }

    public String getAttendance(int studentId) {
        return attendanceMap.getOrDefault(studentId, "Not Marked");
    }

    public void viewAllAttendance() {
        for (Map.Entry<Integer, String> entry : attendanceMap.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}

public class StudentManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static Attendance attendance = new Attendance();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View Attendance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    markAttendance(sc);
                    break;
                case 4:
                    attendance.viewAllAttendance();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }

    private static void addStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void markAttendance(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Attendance Status (Present/Absent): ");
        String status = sc.nextLine();

        attendance.markAttendance(id, status);
        System.out.println("Attendance marked!");
    }
}
