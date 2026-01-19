package coursewise.ui;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import coursewise.util.Constant;

public class MainMenu extends JFrame{
    public MainMenu(){
        super("Course Wise - University Course Registration & Result System");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(Constant.ASSET + "logo.png");
        JLabel imgLabel = new JLabel(icon);
        imgLabel.setBounds(300, 10, 200, 60);
        panel.add(imgLabel);

        JLabel studentId = new JLabel("Student ID");
        studentId.setBounds(250, 100, 100, 30);
        studentId.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(studentId);

        JTextField studentIdField = new JTextField();
        studentIdField.setBounds(250, 132, 300, 30);
        studentIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(studentIdField);

        JLabel password = new JLabel("Password");
        password.setBounds(250, 170, 100, 30);
        password.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(password);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 202, 300, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 250, 100, 30);
        loginButton.setFont(Constant.MAIN_FONT);
        loginButton.setBackground(Constant.PRIMARY_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        panel.add(loginButton);

        JLabel or = new JLabel("OR,");
        or.setBounds(380, 290, 30, 30);
        or.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(or);

        JButton adminLoginButton = new JButton("Login as Admin");
        adminLoginButton.setBounds(325, 320, 150, 30);
        adminLoginButton.setFont(Constant.MAIN_FONT);
        adminLoginButton.setBackground(Constant.SECONDARY_COLOR);
        adminLoginButton.setForeground(Color.WHITE);
        adminLoginButton.setFocusPainted(false);
        panel.add(adminLoginButton);

        this.add(panel);
    }
}
