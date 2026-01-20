package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import coursewise.util.Constant;
import coursewise.service.StudentService;

public class AdminDashboard extends JFrame implements ActionListener {

    JPanel panel, menuPanel, courseBox, studentBox;
    JButton menuButton, logoutButton, coursesButton;
    JLabel courseLabel, courseCountLabel;
    JLabel studentLabel, studentCountLabel;
    boolean isMenuOpen = false;
    StudentService studentService;

    public AdminDashboard() {
        studentService = new StudentService();

        super("Admin Dashboard | Course Wise");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        /* ===== MENU BUTTON ===== */
        menuButton = new JButton("⋮");
        menuButton.setBounds(740, 15, 40, 40);
        menuButton.setFont(new Font("Arial", Font.BOLD, 22));
        menuButton.setBackground(Constant.PRIMARY_COLOR);
        menuButton.setForeground(Color.WHITE);
        menuButton.setFocusPainted(false);
        menuButton.addActionListener(this);
        panel.add(menuButton);

        /* ===== MENU PANEL ===== */
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 1, 10, 10));
        menuPanel.setBounds(620, 60, 150, 60);
        menuPanel.setBackground(Constant.SECONDARY_COLOR);
        menuPanel.setVisible(false);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(Constant.MAIN_FONT);
        logoutButton.setBackground(new Color(231, 76, 60));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(this);
        menuPanel.add(logoutButton);

        panel.add(menuPanel);

        /* ===== COURSES BUTTON ===== */
        coursesButton = new JButton("Courses");
        coursesButton.setBounds(330, 90, 140, 35);
        coursesButton.setFont(Constant.MAIN_FONT);
        coursesButton.setBackground(Constant.PRIMARY_COLOR);
        coursesButton.setForeground(Color.WHITE);
        coursesButton.setFocusPainted(false);
        coursesButton.addActionListener(this);  // ✅ Add listener
        panel.add(coursesButton);

        /* ===== COURSE BOX ===== */
        courseBox = new JPanel();
        courseBox.setLayout(new BorderLayout());
        courseBox.setBounds(150, 150, 200, 120);
        courseBox.setBackground(Constant.PRIMARY_COLOR);

        courseLabel = new JLabel("Total Courses");
        courseLabel.setFont(new Font("Arial", Font.BOLD, 16));
        courseLabel.setForeground(Color.WHITE);

        courseCountLabel = new JLabel("30");
        courseCountLabel.setFont(new Font("Arial", Font.BOLD, 32));
        courseCountLabel.setForeground(Color.WHITE);

        courseBox.add(courseLabel, BorderLayout.NORTH);
        courseBox.add(courseCountLabel, BorderLayout.CENTER);

        panel.add(courseBox);

        /* ===== STUDENT BOX ===== */
        studentBox = new JPanel();
        studentBox.setLayout(new BorderLayout());
        studentBox.setBounds(450, 150, 200, 120);
        studentBox.setBackground(Constant.SECONDARY_COLOR);

        studentLabel = new JLabel("Active Students");
        studentLabel.setFont(new Font("Arial", Font.BOLD, 16));
        studentLabel.setForeground(Color.WHITE);

        studentCountLabel = new JLabel(" " + studentService.getStudentCount());
        studentCountLabel.setFont(new Font("Arial", Font.BOLD, 32));
        studentCountLabel.setForeground(Color.WHITE);

        studentBox.add(studentLabel, BorderLayout.NORTH);
        studentBox.add(studentCountLabel, BorderLayout.CENTER);

        panel.add(studentBox);

        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == menuButton) {
            isMenuOpen = !isMenuOpen;
            menuPanel.setVisible(isMenuOpen);
        } 
        else if (ae.getSource() == logoutButton) {
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setVisible(true);
            this.dispose();
        } 
        else if (ae.getSource() == coursesButton) {
            Courses coursesPage = new Courses();  // ✅ Open Courses page
            coursesPage.setVisible(true);
            this.dispose();  // Close AdminDashboard
        }
    }
}
