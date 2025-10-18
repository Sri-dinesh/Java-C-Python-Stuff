import java.util.*;

class Employee {
  int eid;
  String empName;
  double sal;

  Employee(int eid, String empName, double sal) {
    this.eid = eid;
    this.empName = empName;
    this.sal = sal;
  }
}

public class EmpArrayList {
  public static void main(String[] args) {
    ArrayList<Employee> list = new ArrayList<>();

    Employee e1 = new Employee(001, "Sridinesh", 90000);
    Employee e2 = new Employee(002, "Rahul", 1000000);
    Employee e3 = new Employee(003, "Yashwanth", 80000);

    list.add(e1);
    list.add(e2);
    list.add(e3);

    System.out.println("The no.of total employees are: " + list.size());

    System.out.println(list);
    for (Employee e : list) {
      System.out.println(e.eid + " " + e.empName + " " + e.sal);
    }

    while (true) {

      Scanner sc = new Scanner(System.in);

      System.out.println("Enter your choice - 1. Insert | 2. Delete | 3.Display");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Insert");
          System.out.println("Enter emp details:");
          int eid = sc.nextInt();
          String empName = sc.next();
          double sal = sc.nextDouble();
          Employee e4 = new Employee(eid, empName, sal);
          list.add(e4);
          System.out.println(e4.eid + " " + e4.empName + " " + e4.sal);
          break;

        case 2:
          System.out.println("Delete - enter emo to delete");
          int index = sc.nextInt();
          list.remove(index);
          Employee ep = e4dd
          System.out.println(ep.eid + ep.empName + ep.sal);
          break;

        case 3:
          for (Employee e : list) {
            System.out.println(e.eid + " " + e.empName + " " + e.sal);
          }
          break;
      }
      System.out.println("The no.of total employees are: " + list.size());

    }
  }
}
