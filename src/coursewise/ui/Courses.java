package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Courses extends JFrame implements ActionListener {

    JPanel mainPanel;
    JTextField searchField;
    JButton searchButton, addCourseButton, backButton;
    JPanel courseListArea;

    public Courses() {

        setTitle("Courses");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel);

        /* ===== SEARCH BOX ===== */
        searchField = new JTextField();
        searchField.setBounds(30, 20, 220, 30);
        mainPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(260, 20, 80, 30);
        mainPanel.add(searchButton);

        /* ===== ADD COURSE BUTTON ===== */
        addCourseButton = new JButton("Add Course");
        addCourseButton.setBounds(850, 20, 120, 30);
        addCourseButton.addActionListener(this); // ✅ Add listener
        mainPanel.add(addCourseButton);

        /* ===== BACK BUTTON ===== */
        backButton = new JButton("Back");
        backButton.setBounds(30, 450, 100, 30);
        backButton.addActionListener(this);
        mainPanel.add(backButton);

        /* ===== TABLE HEADER ===== */
        int x = 10;
        JLabel codeHeader = new JLabel("Course Code");
        codeHeader.setBounds(x, 80, 100, 25);
        mainPanel.add(codeHeader);

        x += 110;
        JLabel courseNameHeader = new JLabel("Course Name");
        courseNameHeader.setBounds(x, 80, 120, 25);
        mainPanel.add(courseNameHeader);

        x += 130;
        JLabel day1Header = new JLabel("Day1");
        day1Header.setBounds(x, 80, 50, 25);
        mainPanel.add(day1Header);

        x += 60;
        JLabel day1StartHeader = new JLabel("Start");
        day1StartHeader.setBounds(x, 80, 50, 25);
        mainPanel.add(day1StartHeader);

        x += 60;
        JLabel day1EndHeader = new JLabel("End");
        day1EndHeader.setBounds(x, 80, 50, 25);
        mainPanel.add(day1EndHeader);

        x += 60;
        JLabel day2Header = new JLabel("Day2");
        day2Header.setBounds(x, 80, 50, 25);
        mainPanel.add(day2Header);

        x += 60;
        JLabel day2StartHeader = new JLabel("Start");
        day2StartHeader.setBounds(x, 80, 50, 25);
        mainPanel.add(day2StartHeader);

        x += 60;
        JLabel day2EndHeader = new JLabel("End");
        day2EndHeader.setBounds(x, 80, 50, 25);
        mainPanel.add(day2EndHeader);

        x += 60;
        JLabel roomHeader = new JLabel("Room No");
        roomHeader.setBounds(x, 80, 70, 25);
        mainPanel.add(roomHeader);

        x += 80;
        JLabel actionHeader = new JLabel("Action");
        actionHeader.setBounds(x, 80, 80, 25);
        mainPanel.add(actionHeader);

        /* ===== EMPTY AREA FOR COURSE LIST ===== */
        courseListArea = new JPanel();
        courseListArea.setBounds(10, 110, 960, 320);
        courseListArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
        courseListArea.setLayout(null); // for dynamic rows
        mainPanel.add(courseListArea);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            AdminDashboard dashboard = new AdminDashboard();
            dashboard.setVisible(true);
            this.dispose();
        } 
        else if (ae.getSource() == addCourseButton) {
            AddCourse addCoursePage = new AddCourse(); // ✅ Open AddCourse page
            addCoursePage.setVisible(true);
            this.dispose();
        }
    }
}
