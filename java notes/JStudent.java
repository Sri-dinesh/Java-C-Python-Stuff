import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JStudent {
  JFrame f;
  JTable j;

  JStudent() {
    f = new JFrame();
    f.setTitle("JTable Example");

    String[][] data = {
      {"101", "Rajesh", "CSE", "||", "78.5"},
      {"102", "Harsha", "CSE", "||", "87.5"},
      {"103", "Varsha", "CSE", "||", "65.5"}
    };

    String[] head = {"Rollno", "Name", "Department", "Branch", "Percentage"};

    j = new JTable(data, head);
    j.setBounds(30, 40, 200, 300);

    JScrollPane sp = new JScrollPane(j);

    f.add(sp);
    f.setSize(500, 200);
    f.setVisible(true);
  }

  public static void main(String[] args) {
    new JStudent();
  }
}
