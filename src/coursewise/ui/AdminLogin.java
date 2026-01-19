package coursewise.ui;

import javax.swing.*;

import java.awt.*;
import coursewise.util.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener{
    JPanel panel;
    ImageIcon icon;
    JLabel imgLabel, username, password, or;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, studentLoginButton;


    public AdminLogin(){
        super("Admin Login | Course Wise - University Course Registration & Result System");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);

        icon = new ImageIcon(Constant.ASSET + "logo.png");
        imgLabel = new JLabel(icon);
        imgLabel.setBounds(300, 10, 200, 60);
        panel.add(imgLabel);

        username = new JLabel("Username");
        username.setBounds(250, 100, 100, 30);
        username.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(username);

        usernameField = new JTextField();
        usernameField.setBounds(250, 132, 300, 30);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(usernameField);

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
        or.setBounds(380, 290, 30, 30);
        or.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(or);

        studentLoginButton = new JButton("Login as Student");
        studentLoginButton.setBounds(312, 320, 175, 30);
        studentLoginButton.setFont(Constant.MAIN_FONT);
        studentLoginButton.setBackground(Constant.SECONDARY_COLOR);
        studentLoginButton.setForeground(Color.WHITE);
        studentLoginButton.setFocusPainted(false);
        studentLoginButton.addActionListener(this);
        panel.add(studentLoginButton);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == studentLoginButton){
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            this.dispose();
        }
    }
}
