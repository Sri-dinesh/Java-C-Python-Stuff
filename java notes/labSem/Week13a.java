import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Week13a implements ActionListener {

    String data = "EMP: ";
    JFrame f;
    JPanel p;

    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3;
    JRadioButton r1, r2;
    ButtonGroup bg;
    JComboBox jc;
    JCheckBox c1, c2, c3, c4;
    JButton b1;
    JTextArea ta1;

    String cities[] = { "New York", "Silicon Valley", "Paris", "HongKong" };

    public Week13a() {

        f = new JFrame();
        p = new JPanel();

        f.setSize(1920, 1080);
        f.setTitle("Freakingg Employee Details");

        l1 = new JLabel("Emp-ID");
        l2 = new JLabel("Emp-Name");
        l3 = new JLabel("Emp-Designation");
        l4 = new JLabel("Emp-Gender");
        l5 = new JLabel("Emp-City");
        l6 = new JLabel("Emp-Company");

        t1 = new JTextField(30);
        t2 = new JTextField(30);
        t3 = new JTextField(30);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("FeMale");

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        jc = new JComboBox(cities);

        c1 = new JCheckBox("Meta");
        c2 = new JCheckBox("Apple");
        c3 = new JCheckBox("Amazon");
        c4 = new JCheckBox("Netflix");

        b1 = new JButton("Submit");

        ta1 = new JTextArea(50, 50);

        f.setLayout(new GridLayout(5, 5));

        p.add(l1);
        p.add(t1);

        p.add(l2);
        p.add(t2);

        p.add(l3);
        p.add(t3);

        p.add(l4);
        p.add(r1);
        p.add(r2);

        p.add(l5);
        p.add(jc);

        p.add(l6);
        p.add(c1);
        p.add(c2);
        p.add(c3);
        p.add(c4);

        p.add(b1);
        p.add(ta1);

        f.add(p);

        f.setVisible(true);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        data = data + t1.getText() + ":";
        data = data + t2.getText() + ":";
        data = data + t3.getText() + ":";

        if (r1.isSelected()) {
            data = data + "Male" + ":";
        } else {
            data = data + "FeMale" + ":";
        }

        String str = (String) jc.getSelectedItem();

        data = data + str + ":";

        if (c1.isSelected()) {
            data = data + c1.getText();
        } else if (c2.isSelected()) {
            data = data + c2.getText();
        } else {
            data = data + c3.getText();
        }

        ta1.setText(data);
    }

    public static void main(String[] args) {
        new Week13a();
    }

}