package Programs;
import java.util.*;

class Employee {

    int empID;
    String empName;

    Employee(int id, String name) {
        empID = id;
        empName = name;
    }
}

class Salary extends Employee {

    double emp_salary;
    String emp_dept;

    Salary(int id, String name, String dept, double salary) {
        super(id, name);
        emp_salary = salary;
        emp_dept = dept;
    }

    void display() {
        System.out.println(empID + " " + empName + " " + emp_dept + " " + emp_salary);
    }

}

public class DemoInheritance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of elements: ");
        int n = sc.nextInt();

        Salary s[] = new Salary[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter empID:");
            int id = sc.nextInt();

            System.out.println("Enter empName:");
            String name = sc.next();

            System.out.println("Enter empDept");
            String dept = sc.next();

            System.out.println("Enter empSalary:");
            double salary = sc.nextDouble();

            s[i] = new Salary(id, name, dept, salary);
        }
        System.out.println("Employee details after sorting salary > 20000");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Salary temp;
                if (s[i].emp_salary > s[j].emp_salary) {
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (s[i].emp_salary > 20000) {
                s[i].display();
            }
        }
        sc.close();
    }
}
