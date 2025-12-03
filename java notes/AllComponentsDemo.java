import javax.swing.*;
import java.awt.*;

public class AllComponentsDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing Components Demo");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BorderLayout for main frame
        frame.setLayout(new BorderLayout());

        // ----------------------------------
        // Panel 1: Basic Components (FlowLayout)
        // ----------------------------------
        JPanel basicPanel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("Enter Name:");
        basicPanel.add(label);

        JTextField textField = new JTextField(15);
        basicPanel.add(textField);

        JButton button = new JButton("Submit");
        basicPanel.add(button);

        // ImageIcon and JLabel
        ImageIcon icon = new ImageIcon("example.png"); // put any image in project folder
        JLabel imgLabel = new JLabel(icon);
        basicPanel.add(imgLabel);

        // ----------------------------------
        // Panel 2: ComboBox and Table (GridLayout)
        // ----------------------------------
        JPanel tablePanel = new JPanel(new GridLayout(2, 1));

        JComboBox<String> combo = new JComboBox<>(new String[] { "Java", "Python", "C" });
        tablePanel.add(combo);

        String data[][] = {
                { "1", "Alice" },
                { "2", "Bob" }
        };
        String cols[] = { "ID", "Name" };

        JTable table = new JTable(data, cols);
        JScrollPane tableScroll = new JScrollPane(table);
        tablePanel.add(tableScroll);

        // ----------------------------------
        // CardLayout example panel
        // ----------------------------------
        JPanel cardPanel = new JPanel(new CardLayout());

        JLabel card1 = new JLabel("Card One", SwingConstants.CENTER);
        JLabel card2 = new JLabel("Card Two", SwingConstants.CENTER);

        cardPanel.add(card1, "Card1");
        cardPanel.add(card2, "Card2");

        // ----------------------------------
        // JTabbedPane to organize panels
        // ----------------------------------
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Basic", basicPanel);
        tabs.add("Table", tablePanel);
        tabs.add("Cards", cardPanel);

        // Add tabs to center of frame
        frame.add(tabs, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
