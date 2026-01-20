package coursewise.ui;

import coursewise.model.Course;
import coursewise.model.Student;
import coursewise.service.CourseService;
import coursewise.service.EnrollmentService;
import coursewise.service.StudentService;
import coursewise.util.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseRegistration extends JFrame implements ActionListener {
    private Student student;
    private JPanel panel, enrolledPanel, searchPanel, courseContainerPanel, menuPanel;
    private JCheckBox[] checkboxes;
    private Course[] allCourses;
    private JTextField searchField;
    private CourseService courseService = new CourseService();
    private EnrollmentService enrollmentService = new EnrollmentService();
    private StudentService studentService = new StudentService();
    private ImageIcon icon;
    private JButton menuButton, profileButton, searchBtn, registrationButton, registerBtn;
    private JButton resultsButton, logoutButton;
    private boolean isMenuOpen = false;

    public CourseRegistration(Student student) {
        this.student = student;
        setTitle("Course Registration - " + student.getName());
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        // Logo
        icon = new ImageIcon(Constant.ASSET + "logo.png");
        JLabel imgLabel = new JLabel(icon);
        imgLabel.setBounds(10, 10, 200, 60);
        panel.add(imgLabel);

        // Menu Button
        menuButton = new JButton("≡ Menu");
        menuButton.setBounds(650, 20, 100, 40);
        menuButton.setFont(Constant.MAIN_FONT);
        menuButton.setBackground(Constant.PRIMARY_COLOR);
        menuButton.setForeground(Color.WHITE);
        menuButton.setFocusPainted(false);
        menuButton.addActionListener(this);
        panel.add(menuButton);

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10));
        menuPanel.setBackground(Constant.SECONDARY_COLOR);
        menuPanel.setBounds(500, 60, 250, 200);
        menuPanel.setVisible(false);

        profileButton = new JButton("Profile");
        profileButton.setFont(Constant.MAIN_FONT);
        profileButton.setBackground(Constant.PRIMARY_COLOR);
        profileButton.setForeground(Color.WHITE);
        profileButton.setFocusPainted(false);
        profileButton.addActionListener(this);
        menuPanel.add(profileButton);

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

        // Enrolled Courses Section
        JLabel enrolledTitle = new JLabel("Already Enrolled Courses:");
        enrolledTitle.setBounds(10, 80, 300, 25);
        enrolledTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(enrolledTitle);

        enrolledPanel = new JPanel();
        enrolledPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        enrolledPanel.setBackground(new Color(240, 240, 240));
        JScrollPane enrolledScroll = new JScrollPane(enrolledPanel);
        enrolledScroll.setBounds(10, 110, 780, 70);
        panel.add(enrolledScroll);

        // Search Section
        JLabel searchLabel = new JLabel("Search & Register Courses:");
        searchLabel.setBounds(10, 190, 300, 25);
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(searchLabel);

        searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        searchField = new JTextField(30);
        searchBtn = new JButton("Search");
        searchBtn.addActionListener(this);
        searchPanel.add(new JLabel("Search:")); 
        searchPanel.add(searchField); 
        searchPanel.add(searchBtn);
        searchPanel.setBounds(10, 215, 780, 40);
        panel.add(searchPanel);

        // Available Courses Panel
        courseContainerPanel = new JPanel();
        courseContainerPanel.setLayout(new BoxLayout(courseContainerPanel, BoxLayout.Y_AXIS));
        JScrollPane courseScroll = new JScrollPane(courseContainerPanel);
        courseScroll.setBounds(10, 260, 780, 170);
        panel.add(courseScroll);

        // Register Button
        registerBtn = new JButton("Register Selected");
        registerBtn.setBounds(10, 435, 200, 35);
        registerBtn.setFont(Constant.MAIN_FONT);
        registerBtn.setBackground(Constant.PRIMARY_COLOR);
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFocusPainted(false);
        registerBtn.addActionListener(this);
        panel.add(registerBtn);

        this.add(panel);

        // Load enrolled and available courses
        loadEnrolledCourses();
        loadCourses(courseContainerPanel, "");
    }

    private void loadEnrolledCourses() {
        enrolledPanel.removeAll();
        String enrolledCoursesStr = student.getEnrolledCourses();
        
        if (enrolledCoursesStr == null || enrolledCoursesStr.isEmpty()) {
            enrolledPanel.add(new JLabel("No courses enrolled yet."));
        } else {
            String[] enrolled = enrolledCoursesStr.split(",");
            for (String code : enrolled) {
                code = code.trim();
                if (!code.isEmpty()) {
                    // Create a panel for each course with close button
                    JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
                    coursePanel.setBackground(Constant.PRIMARY_COLOR);
                    coursePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
                    
                    JLabel courseLabel = new JLabel(code);
                    courseLabel.setForeground(Color.WHITE);
                    coursePanel.add(courseLabel);
                    
                    JButton closeBtn = new JButton("×");
                    closeBtn.setForeground(Color.WHITE);
                    closeBtn.setBackground(Constant.PRIMARY_COLOR);
                    closeBtn.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                    closeBtn.setFocusPainted(false);
                    closeBtn.setFont(new Font("Arial", Font.BOLD, 16));
                    final String courseCode = code;
                    closeBtn.addActionListener(e -> removeEnrolledCourse(courseCode));
                    coursePanel.add(closeBtn);
                    
                    enrolledPanel.add(coursePanel);
                }
            }
        }
        enrolledPanel.revalidate();
        enrolledPanel.repaint();
    }
    
    private void removeEnrolledCourse(String courseCode) {
        String enrolledCoursesStr = student.getEnrolledCourses();
        if (enrolledCoursesStr != null && !enrolledCoursesStr.isEmpty()) {
            String[] enrolled = enrolledCoursesStr.split(",");
            StringBuilder updatedCourses = new StringBuilder();
            
            for (String code : enrolled) {
                code = code.trim();
                if (!code.equalsIgnoreCase(courseCode)) {
                    if (updatedCourses.length() > 0) {
                        updatedCourses.append(",");
                    }
                    updatedCourses.append(code);
                }
            }
            
            student.setEnrolledCourses(updatedCourses.toString());
            studentService.updateStudent(student);
            
            loadEnrolledCourses();
            loadCourses(courseContainerPanel, searchField.getText());
        }
    }

    private void loadCourses(JPanel container, String q) {
        Course[] results = courseService.search(q);
        
        // Filter out already enrolled courses
        String enrolledCoursesStr = student.getEnrolledCourses();
        String[] enrolledCodes = new String[0];
        if (enrolledCoursesStr != null && !enrolledCoursesStr.isEmpty()) {
            enrolledCodes = enrolledCoursesStr.split(",");
            for (int i = 0; i < enrolledCodes.length; i++) {
                enrolledCodes[i] = enrolledCodes[i].trim();
            }
        }
        
        // Filter results to exclude enrolled courses
        Course[] filteredResults = new Course[results.length];
        int filteredCount = 0;
        for (int i = 0; i < results.length; i++) {
            if (results[i] == null) continue;
            boolean isEnrolled = false;
            for (String enrolled : enrolledCodes) {
                if (results[i].getCode().equalsIgnoreCase(enrolled)) {
                    isEnrolled = true;
                    break;
                }
            }
            if (!isEnrolled) {
                filteredResults[filteredCount++] = results[i];
            }
        }
        
        // Create final course array
        Course[] finalCourses = new Course[filteredCount];
        System.arraycopy(filteredResults, 0, finalCourses, 0, filteredCount);
        
        allCourses = finalCourses;
        container.removeAll();
        checkboxes = new JCheckBox[finalCourses.length];
        
        for (int i = 0; i < finalCourses.length; i++) {
            if (finalCourses[i] != null) {
                checkboxes[i] = new JCheckBox(finalCourses[i].toString());
                container.add(checkboxes[i]);
            }
        }
        
        container.revalidate();
        container.repaint();
    }

    private void registerSelected() {
        Course[] selected = new Course[checkboxes.length];
        int count = 0;
        for (int i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].isSelected()) {
                selected[count++] = allCourses[i];
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "Please select at least one course.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int success = 0;
        String[] newCourses = new String[count];
        for (int i = 0; i < count; i++) {
            boolean ok = enrollmentService.addEnrollment(student.getStudentId(), selected[i]);
            if (ok) {
                success++;
                newCourses[i] = selected[i].getCode();
            }
        }
        
        // Update student's enrolledCourses in students.txt
        if (success > 0) {
            String currentCourses = student.getEnrolledCourses();
            String updatedCourses = currentCourses;
            for (String course : newCourses) {
                if (course != null) {
                    if (updatedCourses.isEmpty() || updatedCourses.equals("")) {
                        updatedCourses = course;
                    } else {
                        updatedCourses += "," + course;
                    }
                }
            }
            student.setEnrolledCourses(updatedCourses);
            studentService.updateStudent(student);
        }
        
        JOptionPane.showMessageDialog(this, "Registered " + success + " course(s).", "Done", JOptionPane.INFORMATION_MESSAGE);
        loadEnrolledCourses();
        // Clear search and reload courses
        searchField.setText("");
        loadCourses(courseContainerPanel, "");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuButton) {
            isMenuOpen = !isMenuOpen;
            menuPanel.setVisible(isMenuOpen);
        } else if (e.getSource() == profileButton) {
            StudentProfile studentProfile = new StudentProfile(student);
            studentProfile.setVisible(true);
            this.dispose();
        } else if (e.getSource() == resultsButton) {
            isMenuOpen = false;
            menuPanel.setVisible(false);
            this.dispose();
        } else if (e.getSource() == logoutButton) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            this.dispose();
        } else if (e.getSource() == searchBtn) {
            loadCourses(courseContainerPanel, searchField.getText());
        } else if (e.getSource() == registerBtn) {
            registerSelected();
        }
    }
}
