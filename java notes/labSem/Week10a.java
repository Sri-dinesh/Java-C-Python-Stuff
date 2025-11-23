
import java.util.*;

public class Week10a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, String> student = new HashMap<>();

        while (true) {
            System.out.println(
                    "\n1. Insert Student \t 2. Delete Student\t 3. Update Student\t 4. Print All Students\t 5. I wan to freakin Exitt !!\n Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Roll-Number: ");
                    int rollNumber = sc.nextInt();
                    System.out.println("Enter Student Name: ");
                    String studentName = sc.next();

                    student.put(rollNumber, studentName);
                    System.out.println("OMG Student Successfully Insertedd !!!");
                    break;

                case 2:
                    System.out.println("Enter Roll-Number to delete: ");
                    int rollNumberDel = sc.nextInt();
                    if (student.containsKey(rollNumberDel)) {
                        student.remove(rollNumberDel);
                        System.out.println("OMG Student Deleted Successfullyy !!!");
                    } else {
                        System.out.println("Skill-issues(typoMistake) Student Not Deleted Successfullyy !!!");
                    }
                    break;

                case 3:
                    System.out.println("Enter Roll-Number to Update: ");
                    int rollNumberUpdate = sc.nextInt();

                    if (student.containsKey(rollNumberUpdate)) {
                        System.out.println("Enter New Student-Name: ");
                        String newStudentName = sc.next();
                        student.put(rollNumberUpdate, newStudentName);
                        System.out.println("Student Updated Successfullyy !!!");

                    } else {
                        System.out.println("Skill-issues(typoMistake) Student Not Updated Successfullyy !!!");
                    }
                    break;

                case 4:
                    if (student.isEmpty()) {
                        System.out.println("You Idiot - There are Student Details to print !!!");
                    } else {
                        System.out.println("Roll-No\tStudent-Name");
                        for (Map.Entry<Integer, String> entry : student.entrySet()) {
                            System.out.println(entry.getKey() + "\t" + entry.getValue());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Ok I quitt - can't bear this things at all !!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Idiot - Can't even pick a correct choicee !!");
            }
        }
    }
}