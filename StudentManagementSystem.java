import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Student {

    int rollNo;
    String name;
    String course;
    int age;

    public Student(int rollNo, String name, String course, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Course: " + course + ", Age: " + age;
    }
}

public class StudentManagementSystem {

    static List<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                case 2:
                    viewStudents();
                case 3:
                    searchStudent();
                case 4:
                    updateStudent();
                case 5:
                    deleteStudent();
                case 6:
                    System.out.println("Exiting...");
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        studentList.add(new Student(roll, name, course, age));
        System.out.println("✅ Student added successfully.");
    }

    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("❌ No students found.");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();
        for (Student s : studentList) {
            if (s.rollNo == roll) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int roll = sc.nextInt();
        for (Student s : studentList) {
            if (s.rollNo == roll) {
                sc.nextLine(); // clear buffer
                System.out.print("Enter new Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new Course: ");
                s.course = sc.nextLine();
                System.out.print("Enter new Age: ");
                s.age = sc.nextInt();
                System.out.println("✅ Student updated.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int roll = sc.nextInt();
        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            if (itr.next().rollNo == roll) {
                itr.remove();
                System.out.println("✅ Student deleted.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }
}