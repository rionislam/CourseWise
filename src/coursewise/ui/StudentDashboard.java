package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import coursewise.model.Student;
import coursewise.util.Constant;

public class StudentDashboard extends JFrame implements ActionListener {
    JPanel panel, menuPanel;
    ImageIcon icon;
    JLabel imgLabel, welcomeLabel;
    JButton menuButton, profileButton, registrationButton, resultsButton, logoutButton;
    JMenuBar menuBar;
    Student currentStudent;
    boolean isMenuOpen = false;

    public StudentDashboard(Student student) {
        currentStudent = student;
        super("Student Dashboard | Course Wise - University Course Registration & Result System");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);

        icon = new ImageIcon(Constant.ASSET + "logo.png");
        imgLabel = new JLabel(icon);
        imgLabel.setBounds(10, 10, 200, 60);
        panel.add(imgLabel);

        menuButton = new JButton("≡ Menu");
        menuButton.setBounds(650, 20, 100, 40);
        menuButton.setFont(Constant.MAIN_FONT);
        menuButton.setBackground(Constant.PRIMARY_COLOR);
        menuButton.setForeground(Color.WHITE);
        menuButton.setFocusPainted(false);
        menuButton.addActionListener(this);
        panel.add(menuButton);

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1, 10, 10));
        menuPanel.setBackground(Constant.SECONDARY_COLOR);
        menuPanel.setBounds(500, 60, 250, 200);
        menuPanel.setVisible(false);


        registrationButton = new JButton("Register Courses");
        registrationButton.setFont(Constant.MAIN_FONT);
        registrationButton.setBackground(Constant.PRIMARY_COLOR);
        registrationButton.setForeground(Color.WHITE);
        registrationButton.setFocusPainted(false);
        registrationButton.addActionListener(this);
        menuPanel.add(registrationButton);

        resultsButton = new JButton("View Results");
        resultsButton.setFont(Constant.MAIN_FONT);
        resultsButton.setBackground(Constant.PRIMARY_COLOR);
        resultsButton.setForeground(Color.WHITE);
        resultsButton.setFocusPainted(false);
        resultsButton.addActionListener(this);
        menuPanel.add(resultsButton);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(Constant.MAIN_FONT);
        logoutButton.setBackground(new Color(231, 76, 60));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(this);
        menuPanel.add(logoutButton);

        panel.add(menuPanel);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == menuButton) {
            isMenuOpen = !isMenuOpen;
            menuPanel.setVisible(isMenuOpen);
        } else if (ae.getSource() == logoutButton) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            this.dispose();
        }
    }
}
