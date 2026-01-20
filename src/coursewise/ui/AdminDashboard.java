package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import coursewise.util.Constant;
import coursewise.service.StudentService;

// Import AddStudent page
import coursewise.ui.AddStudent;

public class AdminDashboard extends JFrame implements ActionListener {

    JPanel panel, menuPanel, courseBox, studentBox;
    JButton menuButton, logoutButton, menuCoursesButton, menuResultButton, menuAddStudentButton;
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
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10)); // 4 button
        menuPanel.setBackground(Constant.SECONDARY_COLOR);
        menuPanel.setBounds(500, 60, 250, 250);
        menuPanel.setVisible(false);

        /* ===== MENU COURSES BUTTON ===== */
        menuCoursesButton = new JButton("Courses");
        menuCoursesButton.setFont(Constant.MAIN_FONT);
        menuCoursesButton.setBackground(Constant.PRIMARY_COLOR);
        menuCoursesButton.setForeground(Color.WHITE);
        menuCoursesButton.setFocusPainted(false);
        menuCoursesButton.addActionListener(this);
        menuPanel.add(menuCoursesButton);

        /* ===== MENU RESULT BUTTON ===== */
        menuResultButton = new JButton("Result");
        menuResultButton.setFont(Constant.MAIN_FONT);
        menuResultButton.setBackground(new Color(52, 152, 219));
        menuResultButton.setForeground(Color.WHITE);
        menuResultButton.setFocusPainted(false);
        menuResultButton.addActionListener(this);
        menuPanel.add(menuResultButton);

        /* ===== MENU ADD STUDENT BUTTON ===== */
        menuAddStudentButton = new JButton("Add Student");
        menuAddStudentButton.setFont(Constant.MAIN_FONT);
        menuAddStudentButton.setBackground(new Color(46, 204, 113)); // green
        menuAddStudentButton.setForeground(Color.WHITE);
        menuAddStudentButton.setFocusPainted(false);
        menuAddStudentButton.addActionListener(this);
        menuPanel.add(menuAddStudentButton);

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
        courseBox.setBounds(150, 150, 200, 120);
        courseBox.setBackground(Constant.PRIMARY_COLOR);

        courseLabel = new JLabel("Total Courses", SwingConstants.CENTER);
        courseLabel.setFont(new Font("Arial", Font.BOLD, 16));
        courseLabel.setForeground(Color.WHITE);

        courseCountLabel = new JLabel("30", SwingConstants.CENTER);
        courseCountLabel.setFont(new Font("Arial", Font.BOLD, 32));
        courseCountLabel.setForeground(Color.WHITE);

        courseBox.add(courseLabel, BorderLayout.NORTH);
        courseBox.add(courseCountLabel, BorderLayout.CENTER);
        panel.add(courseBox);

        /* ===== STUDENT BOX ===== */
        studentBox = new JPanel(new BorderLayout());
        studentBox.setBounds(450, 150, 200, 120);
        studentBox.setBackground(Constant.SECONDARY_COLOR);

        studentLabel = new JLabel("Active Students", SwingConstants.CENTER);
        studentLabel.setFont(new Font("Arial", Font.BOLD, 16));
        studentLabel.setForeground(Color.WHITE);

        studentCountLabel = new JLabel(
                " " + studentService.getStudentCount(),
                SwingConstants.CENTER
        );
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

        else if (ae.getSource() == menuCoursesButton) {
            Courses coursesPage = new Courses();
            coursesPage.setVisible(true);
            this.dispose();
        }

        else if (ae.getSource() == menuResultButton) {
            ResultPage resultPage = new ResultPage();
            resultPage.setVisible(true);
            this.dispose();
        }

        else if (ae.getSource() == menuAddStudentButton) {
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
