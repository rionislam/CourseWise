package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import coursewise.util.Constant;
import coursewise.model.Course;
import coursewise.service.CourseService;

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
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

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

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 4 button
        menuPanel.setBackground(Constant.SECONDARY_COLOR);
        menuPanel.setBounds(500, 60, 250, 300);
        menuPanel.setVisible(false);

        dashboardButton = new JButton("Dashboard");
        dashboardButton.setFont(Constant.MAIN_FONT);
        dashboardButton.setBackground(Constant.PRIMARY_COLOR);
        dashboardButton.setForeground(Color.WHITE);
        dashboardButton.setFocusPainted(false);
        dashboardButton.addActionListener(this);
        menuPanel.add(dashboardButton);

        coursesButton = new JButton("Courses");
        coursesButton.setFont(Constant.MAIN_FONT);
        coursesButton.setBackground(Constant.PRIMARY_COLOR);
        coursesButton.setForeground(Color.WHITE);
        coursesButton.setFocusPainted(false);
        coursesButton.addActionListener(this);
        menuPanel.add(coursesButton);

        resultsButton = new JButton("Result");
        resultsButton.setFont(Constant.MAIN_FONT);
        resultsButton.setBackground(new Color(52, 152, 219));
        resultsButton.setForeground(Color.WHITE);
        resultsButton.setFocusPainted(false);
        resultsButton.addActionListener(this);
        menuPanel.add(resultsButton);

        addStudentButton = new JButton("Add Student");
        addStudentButton.setFont(Constant.MAIN_FONT);
        addStudentButton.setBackground(Constant.PRIMARY_COLOR);
        addStudentButton.setForeground(Color.WHITE);
        addStudentButton.setFocusPainted(false);
        addStudentButton.addActionListener(this);
        menuPanel.add(addStudentButton);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(Constant.MAIN_FONT);
        logoutButton.setBackground(new Color(231, 76, 60));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(this);
        menuPanel.add(logoutButton);

        panel.add(menuPanel);

        searchField = new JTextField();
        searchField.setBounds(30, 90, 220, 30);
        panel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(260, 90, 80, 30);
        panel.add(searchButton);

        addCourseButton = new JButton("Add Course");
        addCourseButton.setBounds(650, 90, 120, 30);
        addCourseButton.setFont(Constant.MAIN_FONT);
        addCourseButton.setBackground(Constant.PRIMARY_COLOR);
        addCourseButton.setForeground(Color.WHITE);
        addCourseButton.setFocusPainted(false);
        addCourseButton.addActionListener(this);
        panel.add(addCourseButton);

        int x = 10;

        JLabel codeHeader = new JLabel("Course Code");
        codeHeader.setBounds(x, 140, 80, 25);
        panel.add(codeHeader);

        x += 90;
        JLabel courseNameHeader = new JLabel("Course Name");
        courseNameHeader.setBounds(x, 140, 140, 25);
        panel.add(courseNameHeader);

        x += 150;
        JLabel day1Header = new JLabel("Day1");
        day1Header.setBounds(x, 140, 100, 25);
        panel.add(day1Header);

        x += 110;
        JLabel day2Header = new JLabel("Day2");
        day2Header.setBounds(x, 140, 100, 25);
        panel.add(day2Header);

        x += 110;
        JLabel roomHeader = new JLabel("Capacity");
        roomHeader.setBounds(x, 140, 70, 25);
        panel.add(roomHeader);

        x += 80;
        JLabel actionHeader = new JLabel("Count");
        actionHeader.setBounds(x, 140, 50, 25);
        panel.add(actionHeader);

        courseListArea = new JPanel();
        courseListArea.setBounds(10, 140, 770, 350);
        courseListArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
        courseListArea.setLayout(null);
        panel.add(courseListArea);

        this.add(panel);
    }

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
            addCouse();
        }
    }

    public void addCouse(){
        JTextField courseCodeField = new JTextField();
        JTextField courseNameField = new JTextField();
        JTextField day1Field = new JTextField();
        JTextField day1StartField = new JTextField();
        JTextField day1EndField = new JTextField();
        JTextField day2Field = new JTextField();
        JTextField day2StartField = new JTextField();
        JTextField day2EndField = new JTextField();
        JTextField capacityField = new JTextField();
        JTextField countField = new JTextField();
        JTextField sectionField = new JTextField();
        JTextField semesterField = new JTextField();

        JPanel form = new JPanel(new GridLayout(12, 2, 8, 8));
        form.add(new JLabel("Course Code:"));
        form.add(courseCodeField);

        form.add(new JLabel("Course Name:"));
        form.add(courseNameField);

        form.add(new JLabel("Day 1:"));
        form.add(day1Field);

        form.add(new JLabel("Day 1 Start Time:"));
        form.add(day1StartField);

        form.add(new JLabel("Day 1 End Time:"));
        form.add(day1EndField);

        form.add(new JLabel("Day 2:"));
        form.add(day2Field);

        form.add(new JLabel("Day 2 Start Time:"));
        form.add(day2StartField);

        form.add(new JLabel("Day 2 End Time:"));
        form.add(day2EndField);

        form.add(new JLabel("Capacity:"));
        form.add(capacityField);

        form.add(new JLabel("Enrolled Count:"));
        form.add(countField);

        form.add(new JLabel("Section:"));
        form.add(sectionField);

        form.add(new JLabel("Semester:"));
        form.add(semesterField);

        int option = JOptionPane.showConfirmDialog(this, form, "Add New Course", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            String courseCode = courseCodeField.getText();
            String courseName = courseNameField.getText();
            String day1 = day1Field.getText();
            String day1Start = day1StartField.getText();
            String day1End = day1EndField.getText();
            String day2 = day2Field.getText();
            String day2Start = day2StartField.getText();
            String day2End = day2EndField.getText();
            String capacity = capacityField.getText();
            String enrolledCount = countField.getText();
            String section = sectionField.getText();
            String semester = semesterField.getText();

            Course course = new Course(courseCode, courseName, day1, day1Start, day1End,
                    day2, day2Start, day2End, section,
                    Integer.parseInt(capacity), Integer.parseInt(enrolledCount),
                    "Active", semester);
            CourseService courseService = new CourseService();
            boolean ok = courseService.addCourse(course);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Course added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add course. Please try again.");
            }
        }
    }
}
