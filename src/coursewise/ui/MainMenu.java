package coursewise.ui;

import javax.swing.*;

import java.awt.*;
import coursewise.util.*;
import coursewise.service.StudentService;
import coursewise.model.Student;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener{
    JPanel panel;
    ImageIcon icon;
    JLabel imgLabel, studentId, password, or;
    JTextField studentIdField;
    JPasswordField passwordField;
    JButton loginButton, adminLoginButton;

    public MainMenu(){
        super("Course Wise - University Course Registration & Result System");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);

        icon = new ImageIcon(Constant.ASSET + "logo.png");
        imgLabel = new JLabel(icon);
        imgLabel.setBounds(300, 10, 200, 60);
        panel.add(imgLabel);

        studentId = new JLabel("Student ID");
        studentId.setBounds(250, 100, 100, 30);
        studentId.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(studentId);

        studentIdField = new JTextField();
        studentIdField.setBounds(250, 132, 300, 30);
        studentIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(studentIdField);

        password = new JLabel("Password");
        password.setBounds(250, 170, 100, 30);
        password.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 202, 300, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(350, 250, 100, 30);
        loginButton.setFont(Constant.MAIN_FONT);
        loginButton.setBackground(Constant.PRIMARY_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        or = new JLabel("OR,");
        or.setBounds(385, 290, 30, 30);
        or.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(or);

        adminLoginButton = new JButton("Login as Admin");
        adminLoginButton.setBounds(325, 320, 150, 30);
        adminLoginButton.setFont(Constant.MAIN_FONT);
        adminLoginButton.setBackground(Constant.SECONDARY_COLOR);
        adminLoginButton.setForeground(Color.WHITE);
        adminLoginButton.setFocusPainted(false);
        adminLoginButton.addActionListener(this);
        panel.add(adminLoginButton);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == loginButton){
            String id = studentIdField.getText();
            String pass = new String(passwordField.getPassword());
            
            if(id.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both Student ID and Password", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            StudentService service = new StudentService();
            Student student = service.authenticateStudent(id, pass);
            
            if(student != null) {
                StudentProfile profile = new StudentProfile(student);
                profile.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Student ID or Password", 
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
                passwordField.setText("");
            }
        }
        else if(ae.getSource() == adminLoginButton){
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setVisible(true);
            this.dispose();
        }
    }
}

