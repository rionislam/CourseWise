package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import coursewise.util.Constant;

public class AddStudent extends JFrame implements ActionListener {

    JPanel panel;
    JLabel nameLabel, idLabel, emailLabel, mobileLabel, passwordLabel;
    JTextField nameField, idField, emailField, mobileField;
    JPasswordField passwordField;
    JButton backButton, confirmButton;

    public AddStudent() {
        super("Add Student | Course Wise");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        /* ===== TITLE ===== */
        JLabel title = new JLabel("Add New Student");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(200, 20, 250, 30);
        panel.add(title);

        /* ===== STUDENT NAME ===== */
        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(100, 80, 120, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(250, 80, 200, 25);
        panel.add(nameField);

        /* ===== STUDENT ID ===== */
        idLabel = new JLabel("Student ID:");
        idLabel.setBounds(100, 130, 120, 25);
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(250, 130, 200, 25);
        panel.add(idField);

        /* ===== EMAIL ===== */
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 180, 120, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(250, 180, 200, 25);
        panel.add(emailField);

        /* ===== MOBILE ===== */
        mobileLabel = new JLabel("Mobile:");
        mobileLabel.setBounds(100, 230, 120, 25);
        panel.add(mobileLabel);

        mobileField = new JTextField();
        mobileField.setBounds(250, 230, 200, 25);
        panel.add(mobileField);

        /* ===== PASSWORD ===== */
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 280, 120, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 280, 200, 25);
        panel.add(passwordField);

        /* ===== CONFIRM BUTTON ===== */
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(250, 350, 100, 35);
        confirmButton.setBackground(Constant.PRIMARY_COLOR);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(Constant.MAIN_FONT);
        confirmButton.addActionListener(this);
        panel.add(confirmButton);

        /* ===== BACK BUTTON ===== */
        backButton = new JButton("Back");
        backButton.setBounds(100, 350, 100, 35);
        backButton.setBackground(Constant.SECONDARY_COLOR);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(Constant.MAIN_FONT);
        backButton.addActionListener(this);
        panel.add(backButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            // Back to AdminDashboard
            AdminDashboard dashboard = new AdminDashboard();
            dashboard.setVisible(true);
            this.dispose();
        } 
        else if (ae.getSource() == confirmButton) {
            // For now, just show popup
            JOptionPane.showMessageDialog(
                    this,
                    "Student added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Clear fields after adding
            nameField.setText("");
            idField.setText("");
            emailField.setText("");
            mobileField.setText("");
            passwordField.setText("");
        }
    }
}
