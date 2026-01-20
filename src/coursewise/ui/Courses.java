package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import coursewise.util.Constant;

public class Courses extends JFrame implements ActionListener {

    JPanel panel;
    JTextField searchField;
    JButton searchButton, addCourseButton, menuButton;
    JButton dashboardButton, coursesButton, resultsButton, addStudentButton, logoutButton;
    JPanel courseListArea, menuPanel;
    ImageIcon icon;
    boolean isMenuOpen = false;

    public Courses() {
        super("Courses  | Course Wise - University Course Registration & Result System");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        /* ===== LOGO ===== */
        icon = new ImageIcon(Constant.ASSET + "logo.png");
        JLabel imgLabel = new JLabel(icon);
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

        /* ===== MENU PANEL ===== */
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 4 button
        menuPanel.setBackground(Constant.SECONDARY_COLOR);
        menuPanel.setBounds(500, 60, 250, 300);
        menuPanel.setVisible(false);

        /* ===== MENU DASHBOARD BUTTON ===== */
        dashboardButton = new JButton("Dashboard");
        dashboardButton.setFont(Constant.MAIN_FONT);
        dashboardButton.setBackground(Constant.PRIMARY_COLOR);
        dashboardButton.setForeground(Color.WHITE);
        dashboardButton.setFocusPainted(false);
        dashboardButton.addActionListener(this);
        menuPanel.add(dashboardButton);

        /* ===== MENU COURSES BUTTON ===== */
        coursesButton = new JButton("Courses");
        coursesButton.setFont(Constant.MAIN_FONT);
        coursesButton.setBackground(Constant.PRIMARY_COLOR);
        coursesButton.setForeground(Color.WHITE);
        coursesButton.setFocusPainted(false);
        coursesButton.addActionListener(this);
        menuPanel.add(coursesButton);

        /* ===== MENU RESULT BUTTON ===== */
        resultsButton = new JButton("Result");
        resultsButton.setFont(Constant.MAIN_FONT);
        resultsButton.setBackground(new Color(52, 152, 219));
        resultsButton.setForeground(Color.WHITE);
        resultsButton.setFocusPainted(false);
        resultsButton.addActionListener(this);
        menuPanel.add(resultsButton);

        /* ===== MENU ADD STUDENT BUTTON ===== */
        addStudentButton = new JButton("Add Student");
        addStudentButton.setFont(Constant.MAIN_FONT);
        addStudentButton.setBackground(new Color(46, 204, 113)); // green
        addStudentButton.setForeground(Color.WHITE);
        addStudentButton.setFocusPainted(false);
        addStudentButton.addActionListener(this);
        menuPanel.add(addStudentButton);

        /* ===== LOGOUT BUTTON ===== */
        logoutButton = new JButton("Logout");
        logoutButton.setFont(Constant.MAIN_FONT);
        logoutButton.setBackground(new Color(231, 76, 60));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(this);
        menuPanel.add(logoutButton);

        panel.add(menuPanel);

        /* ===== SEARCH BOX ===== */
        searchField = new JTextField();
        searchField.setBounds(30, 90, 220, 30);
        panel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(260, 90, 80, 30);
        panel.add(searchButton);

        /* ===== ADD COURSE BUTTON ===== */
        addCourseButton = new JButton("Add Course");
        addCourseButton.setBounds(650, 90, 120, 30);
        addCourseButton.setFont(Constant.MAIN_FONT);
        addCourseButton.setBackground(Constant.PRIMARY_COLOR);
        addCourseButton.setForeground(Color.WHITE);
        addCourseButton.setFocusPainted(false);
        addCourseButton.addActionListener(this);
        panel.add(addCourseButton);

        /* ===== TABLE HEADER ===== */
        int x = 10;

        JLabel codeHeader = new JLabel("Course Code");
        codeHeader.setBounds(x, 140, 100, 25);
        panel.add(codeHeader);

        x += 110;
        JLabel courseNameHeader = new JLabel("Course Name");
        courseNameHeader.setBounds(x, 140, 120, 25);
        panel.add(courseNameHeader);

        x += 130;
        JLabel day1Header = new JLabel("Day1");
        day1Header.setBounds(x, 140, 50, 25);
        panel.add(day1Header);

        x += 60;
        JLabel day1StartHeader = new JLabel("Start");
        day1StartHeader.setBounds(x, 140, 50, 25);
        panel.add(day1StartHeader);

        x += 60;
        JLabel day1EndHeader = new JLabel("End");
        day1EndHeader.setBounds(x, 140, 50, 25);
        panel.add(day1EndHeader);

        x += 60;
        JLabel day2Header = new JLabel("Day2");
        day2Header.setBounds(x, 140, 50, 25);
        panel.add(day2Header);

        x += 60;
        JLabel day2StartHeader = new JLabel("Start");
        day2StartHeader.setBounds(x, 140, 50, 25);
        panel.add(day2StartHeader);

        x += 60;
        JLabel day2EndHeader = new JLabel("End");
        day2EndHeader.setBounds(x, 140, 50, 25);
        panel.add(day2EndHeader);

        x += 60;
        JLabel roomHeader = new JLabel("Room No");
        roomHeader.setBounds(x, 140, 70, 25);
        panel.add(roomHeader);

        x += 80;
        JLabel actionHeader = new JLabel("Action");
        actionHeader.setBounds(x, 140, 80, 25);
        panel.add(actionHeader);

        /* ===== COURSE LIST AREA ===== */
        courseListArea = new JPanel();
        courseListArea.setBounds(10, 140, 780, 350);
        courseListArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
        courseListArea.setLayout(null);
        panel.add(courseListArea);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == menuButton) {
            isMenuOpen = !isMenuOpen;
            menuPanel.setVisible(isMenuOpen);
        } else if (ae.getSource() == dashboardButton) {
            AdminDashboard dashboard = new AdminDashboard();
            dashboard.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == logoutButton) {
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == addCourseButton) {
            AddCourse addCoursePage = new AddCourse();
            addCoursePage.setVisible(true);
            this.dispose();
        }
    }
}
