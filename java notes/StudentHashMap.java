import java.util.*;

public class StudentHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> studentMap = new HashMap<>();
        while (true) {
            System.out.println("\n1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Print All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int rollNoInsert = scanner.nextInt();
                    System.out.print("Enter student name: ");
                    String nameInsert = scanner.next();
                    studentMap.put(rollNoInsert, nameInsert);
                    System.out.println("Student inserted successfully.");
                    break;
                case 2:
                    System.out.print("Enter roll number to delete: ");
                    int rollNoDelete = scanner.nextInt();
                    if (studentMap.containsKey(rollNoDelete)) {
                        studentMap.remove(rollNoDelete);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter roll number to update: ");
                    int rollNoUpdate = scanner.nextInt();
                    if (studentMap.containsKey(rollNoUpdate)) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        studentMap.put(rollNoUpdate, newName);
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    if (studentMap.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("Roll No\tName");
                        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
                            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}