package Programs;
import java.util.*;

interface Student {
    void displayGrade(char G);

    void attendence(float A);
}

class PGStudent implements Student {

    float attendencePercentage;
    String grade;

    PGStudent(float attendencePercentage, String grade) {
        this.attendencePercentage = attendencePercentage;
        this.grade = grade;
    }

    public void displayGrade() {
        System.out.println("The Grade is: " + grade);
    }

    public void attendence() {
        System.out.println("Attedence Percentage: " + attendencePercentage);
    }

}

class UGStudent implements Student {
    double attendencePercentage;
    String grade;

    UGStudent(double attendencePercentage, String grade) {
        this.attendencePercentage = attendencePercentage;
        this.grade = grade;
    }

    public void displayGrade() {
        System.out.println("The Grade is: " + grade);
    }

    public void attendence() {
        System.out.println("Attedence Percentage: " + attendencePercentage);
    }
}

public class StudentUGPG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter UG Student AttendencePercentage & Grade: ");
        double attendencePercentageUG = sc.nextInt();
        String gradeUG = sc.next();

        System.out.println("Enter PG Student AttendencePercentage & Grade: ");
        double attendencePercentagePG = sc.nextInt();
        String gradePG = sc.next();

        UGStudent us = new UGStudent(attendencePercentageUG, gradeUG);

        PGStudent ps = new PGStudent(attendencePercentagePG, gradePG);

        System.out.println("UG Student Attendence & Grade: ");
        us.attendence();
        us.displayGrade();

        System.out.println("PG Student Attendence & Grade: ");
        ps.attendence();
        ps.displayGrade();

        sc.close();

    }
}
