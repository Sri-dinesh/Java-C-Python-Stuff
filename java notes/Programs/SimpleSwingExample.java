package Programs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleSwingExample {
  public static void main(String[] args) {
    // Create frame
    JFrame frame = new JFrame("Login Page");
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(3, 2, 10, 10));

    // Create components
    JLabel userLabel = new JLabel("Username:");
    JTextField userField = new JTextField();
    JLabel passLabel = new JLabel("Password:");
    JPasswordField passField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JLabel messageLabel = new JLabel("");

    // Add action listener to login button
    loginButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        // Simple validation
        if (username.equals("admin") && password.equals("1234")) {
          messageLabel.setText("Login Successful ✅");
          messageLabel.setForeground(Color.GREEN);
        } else {
          messageLabel.setText("Invalid Credentials ❌");
          messageLabel.setForeground(Color.RED);
        }
      }
    });

    // Add components to frame
    frame.add(userLabel);
    frame.add(userField);
    frame.add(passLabel);
    frame.add(passField);
    frame.add(loginButton);
    frame.add(messageLabel);

    // Center and show window
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
