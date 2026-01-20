package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import coursewise.util.Constant;
import coursewise.service.StudentService;


public class AdminDashboard extends JFrame implements ActionListener {

    JPanel panel, menuPanel, courseBox, studentBox;
    JButton menuButton, dashboardButton, coursesButton, resultsButton, addStudentButton, logoutButton;
    JLabel courseLabel, courseCountLabel;
    JLabel studentLabel, studentCountLabel;
    ImageIcon icon;
    boolean isMenuOpen = false;

    StudentService studentService;

    public AdminDashboard() {
        studentService = new StudentService();

        super("Admin Dashboard | Course Wise - University Course Registration & Result System");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        /* ===== LOGO ===== */
        icon = new ImageIcon(Constant.ASSET + "logo.png");
        JLabel imgLabel = new JLabel(icon);
        imgLabel.setBounds(10, 10, 200, 60);
        panel.add(imgLabel);

        /* ===== MENU BUTTON ===== */
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

        /* ===== COURSE BOX ===== */
        courseBox = new JPanel(new BorderLayout());
        courseBox.setBounds(100, 120, 280, 150);
        courseBox.setBackground(Constant.PRIMARY_COLOR);
        courseBox.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        courseLabel = new JLabel("Total Courses", SwingConstants.CENTER);
        courseLabel.setFont(new Font("Arial", Font.BOLD, 18));
        courseLabel.setForeground(Color.WHITE);

        courseCountLabel = new JLabel("30", SwingConstants.CENTER);
        courseCountLabel.setFont(new Font("Arial", Font.BOLD, 48));
        courseCountLabel.setForeground(Color.WHITE);

        courseBox.add(courseLabel, BorderLayout.NORTH);
        courseBox.add(courseCountLabel, BorderLayout.CENTER);
        panel.add(courseBox);

        /* ===== STUDENT BOX ===== */
        studentBox = new JPanel(new BorderLayout());
        studentBox.setBounds(420, 120, 280, 150);
        studentBox.setBackground(Constant.SECONDARY_COLOR);
        studentBox.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        studentLabel = new JLabel("Active Students", SwingConstants.CENTER);
        studentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        studentLabel.setForeground(Color.WHITE);

        studentCountLabel = new JLabel(
                " " + studentService.getStudentCount(),
                SwingConstants.CENTER
        );
        studentCountLabel.setFont(new Font("Arial", Font.BOLD, 48));
        studentCountLabel.setForeground(Color.WHITE);

        studentBox.add(studentLabel, BorderLayout.NORTH);
        studentBox.add(studentCountLabel, BorderLayout.CENTER);
        panel.add(studentBox);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == menuButton) {
            isMenuOpen = !isMenuOpen;
            menuPanel.setVisible(isMenuOpen);
        }

        else if (ae.getSource() == coursesButton) {
            Courses coursesPage = new Courses();
            coursesPage.setVisible(true);
            this.dispose();
        }

        else if (ae.getSource() == resultsButton) {
            ResultPage resultPage = new ResultPage();
            resultPage.setVisible(true);
            this.dispose();
        }

        else if (ae.getSource() == addStudentButton) {
            AddStudent addStudentPage = new AddStudent();
            addStudentPage.setVisible(true);
            this.dispose();
        }

        else if (ae.getSource() == logoutButton) {
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setVisible(true);
            this.dispose();
        }
    }
}
