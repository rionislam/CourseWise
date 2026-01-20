package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCourse extends JFrame implements ActionListener {

    JPanel mainPanel;
    JTextField courseCodeField, courseNameField, day1Field, day1StartField, day1EndField,
               day2Field, day2StartField, day2EndField, roomField;
    JButton createButton, menuButton, backButton;

    public AddCourse() {

        setTitle("Add Course");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel);

        /* ===== 3 DOT MENU ===== */
        menuButton = new JButton("⋮");
        menuButton.setBounds(440, 10, 40, 30);
        menuButton.setFont(new Font("Arial", Font.BOLD, 20));
        menuButton.setFocusPainted(false);
        mainPanel.add(menuButton);

        /* ===== BACK BUTTON ===== */
        backButton = new JButton("Back");
        backButton.setBounds(20, 10, 80, 30);
        backButton.addActionListener(this);
        mainPanel.add(backButton);

        int y = 60;
        int labelWidth = 120, fieldWidth = 250, height = 30, gap = 10;

        /* ===== COURSE CODE ===== */
        JLabel courseCodeLabel = new JLabel("Course Code:");
        courseCodeLabel.setBounds(30, y, labelWidth, height);
        mainPanel.add(courseCodeLabel);

        courseCodeField = new JTextField();
        courseCodeField.setBounds(160, y, fieldWidth, height);
        mainPanel.add(courseCodeField);

        y += height + gap;

        /* ===== COURSE NAME ===== */
        JLabel courseNameLabel = new JLabel("Course Name:");
        courseNameLabel.setBounds(30, y, labelWidth, height);
        mainPanel.add(courseNameLabel);

        courseNameField = new JTextField();
        courseNameField.setBounds(160, y, fieldWidth, height);
        mainPanel.add(courseNameField);

        y += height + gap;

        /* ===== DAY1 ===== */
        JLabel day1Label = new JLabel("Day1:");
        day1Label.setBounds(30, y, labelWidth, height);
        mainPanel.add(day1Label);

        day1Field = new JTextField();
        day1Field.setBounds(160, y, fieldWidth, height);
        mainPanel.add(day1Field);

        y += height + gap;

        /* ===== DAY1 START ===== */
        JLabel day1StartLabel = new JLabel("Day1 Start:");
        day1StartLabel.setBounds(30, y, labelWidth, height);
        mainPanel.add(day1StartLabel);

        day1StartField = new JTextField();
        day1StartField.setBounds(160, y, fieldWidth, height);
        mainPanel.add(day1StartField);

        y += height + gap;

        /* ===== DAY1 END ===== */
        JLabel day1EndLabel = new JLabel("Day1 End:");
        day1EndLabel.setBounds(30, y, labelWidth, height);
        mainPanel.add(day1EndLabel);

        day1EndField = new JTextField();
        day1EndField.setBounds(160, y, fieldWidth, height);
        mainPanel.add(day1EndField);

        y += height + gap;

        /* ===== DAY2 ===== */
        JLabel day2Label = new JLabel("Day2:");
        day2Label.setBounds(30, y, labelWidth, height);
        mainPanel.add(day2Label);

        day2Field = new JTextField();
        day2Field.setBounds(160, y, fieldWidth, height);
        mainPanel.add(day2Field);

        y += height + gap;

        /* ===== DAY2 START ===== */
        JLabel day2StartLabel = new JLabel("Day2 Start:");
        day2StartLabel.setBounds(30, y, labelWidth, height);
        mainPanel.add(day2StartLabel);

        day2StartField = new JTextField();
        day2StartField.setBounds(160, y, fieldWidth, height);
        mainPanel.add(day2StartField);

        y += height + gap;

        /* ===== DAY2 END ===== */
        JLabel day2EndLabel = new JLabel("Day2 End:");
        day2EndLabel.setBounds(30, y, labelWidth, height);
        mainPanel.add(day2EndLabel);

        day2EndField = new JTextField();
        day2EndField.setBounds(160, y, fieldWidth, height);
        mainPanel.add(day2EndField);

        y += height + gap;

        /* ===== ROOM NUMBER ===== */
        JLabel roomLabel = new JLabel("Room No:");
        roomLabel.setBounds(30, y, labelWidth, height);
        mainPanel.add(roomLabel);

        roomField = new JTextField();
        roomField.setBounds(160, y, fieldWidth, height);
        mainPanel.add(roomField);

        y += height + 2 * gap;

        /* ===== CREATE BUTTON ===== */
        createButton = new JButton("Create");
        createButton.setBounds(180, y, 120, 35);
        createButton.setBackground(new Color(52, 152, 219));
        createButton.setForeground(Color.WHITE);
        createButton.setFocusPainted(false);
        mainPanel.add(createButton);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            Courses coursesPage = new Courses();
            coursesPage.setVisible(true);
            this.dispose();
        }
    }

    /* ===== NO MAIN() METHOD NEEDED ===== */
}
