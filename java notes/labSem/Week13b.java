import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Week13b {
    JFrame f;
    JTable j;

    Week13b() {
        f = new JFrame();

        f.setTitle("Programming Languages Tablee");

        String[][] data = {
                { "101", "Java", "CSE", "II", "78.5" },
                { "102", "Go", "CSE", "II", "87.5" },
                { "103", "Ruby", "CSE", "II", "65.5" },
                { "104", "Rust", "IT", "II", "75.5" },
                { "105", "Elixir", "IT", "II", "87.5" },
        };

        String[] head = { "RollNo", "Name", "Department", "Branch", "Percentage" };

        JTable j = new JTable(data, head);
        j.setBounds(100, 100, 300, 300);

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        f.setSize(1000, 500);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Week13b();
    }
}
