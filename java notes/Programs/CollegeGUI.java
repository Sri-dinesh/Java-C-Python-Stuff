package Programs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CollegeGUI extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public CollegeGUI() {
        super("College Programs and Courses");
        JPanel programPanel = createProgramPanel();
        JPanel coursePanel = createCoursePanel();
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        cardPanel.add(programPanel, "Programs");
        cardPanel.add(coursePanel, "Courses");
        JPanel buttonPanel = new JPanel();
        JButton programButton = new JButton("Programs");
        JButton courseButton = new JButton("Courses");
        programButton.addActionListener(this);
        courseButton.addActionListener(this);
        buttonPanel.add(programButton);
        buttonPanel.add(courseButton);
        add(cardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createProgramPanel() {
        JPanel programPanel = new JPanel();
        programPanel.setLayout(new BorderLayout());
        JTextArea programTextArea = new JTextArea("List of Programs offered by the College");
        programTextArea.setEditable(false);
        programPanel.add(programTextArea, BorderLayout.CENTER);
        return programPanel;
    }

    private JPanel createCoursePanel() {
        JPanel coursePanel = new JPanel();
        coursePanel.setLayout(new BorderLayout());
        JTextArea courseTextArea = new JTextArea("List of Courses offered by the College");
        courseTextArea.setEditable(false);
        coursePanel.add(courseTextArea, BorderLayout.CENTER);
        return coursePanel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Programs")) {
            cardLayout.show(cardPanel, "Programs");
        } else if (e.getActionCommand().equals("Courses")) {
            cardLayout.show(cardPanel, "Courses");
        }
    }

    public static void main(String[] args) {
        new CollegeGUI();
    }
}