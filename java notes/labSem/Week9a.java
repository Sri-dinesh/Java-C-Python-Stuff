import java.util.*;

class Employee {
    int eid;
    String name;
    double sal;

    public Employee(int eid, String name, double sal) {
        this.eid = eid;
        this.name = name;
        this.sal = sal;
    }

}

public class Week9a {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> empList = new ArrayList<>();
        Employee e1 = new Employee(1, "Java", 6000.00);
        Employee e2 = new Employee(2, "Rust", 6000.00);
        Employee e3 = new Employee(3, "Go", 6000.00);
        Employee e4 = new Employee(4, "Ruby", 6000.00);
        Employee e5 = new Employee(5, "TypeScript", 6000.00);

        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);

        System.out.println(empList); // just prints the hashValues i guesss !!
        System.out.println("The size of the freakin employee list is --> " + empList.size());

        System.out.println("Actually now - printing the Employees Detailss !!!");
        for (Employee e : empList) {
            System.out.println(e.eid + " " + e.name + " " + e.sal);
        }

        System.out.println("Removing the data !!");
        empList.remove(2);
        empList.remove(3);
        System.out.println(
                "After laying-off an Employee from the companyyy the actual size of the freakin employees list is --> "
                        + empList.size());

        System.out.println("Actually now - printing the Employees Detailss after some layoffs !!!");
        for (Employee e : empList) {
            System.out.println(e.eid + " " + e.name + " " + e.sal);
        }
    }
}