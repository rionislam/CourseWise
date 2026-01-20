package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import coursewise.model.Student;
import coursewise.service.StudentService;
import coursewise.util.Constant;

public class StudentProfile extends JFrame implements ActionListener {
    JPanel panel, menuPanel;
    ImageIcon icon, avater;
    JLabel imgLabel, avaterLabel, nameLabel, emailLabel, phoneLabel, creditsLabel, cgpaLabel, enrolledCoursesLabel;
    JButton menuButton, profileButton, registrationButton, resultsButton, logoutButton, editAvatarButton, editDetailsButton;
    JMenuBar menuBar;
    Student currentStudent;
    boolean isMenuOpen = false;


    public StudentProfile(Student student) {
        currentStudent = student;
        super("Student Profile | Course Wise - University Course Registration & Result System");
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

        avater = new ImageIcon(Constant.ASSET + "studentImg/" + currentStudent.getAvatarFilename());
        avaterLabel = new JLabel(avater);
        avaterLabel.setBounds(50, 100, 200, 200);
        panel.add(avaterLabel);

        editAvatarButton = new JButton("Edit Avatar");
        editAvatarButton.setBounds(85, 310, 130, 35);
        editAvatarButton.setFont(Constant.MAIN_FONT);
        editAvatarButton.setBackground(Constant.PRIMARY_COLOR);
        editAvatarButton.setForeground(Color.WHITE);
        editAvatarButton.setFocusPainted(false);
        editAvatarButton.addActionListener(this);
        panel.add(editAvatarButton);

        editDetailsButton = new JButton("Edit Details");
        editDetailsButton.setBounds(85, 355, 130, 35);
        editDetailsButton.setFont(Constant.MAIN_FONT);
        editDetailsButton.setBackground(Constant.SECONDARY_COLOR);
        editDetailsButton.setForeground(Color.WHITE);
        editDetailsButton.setFocusPainted(false);
        editDetailsButton.addActionListener(this);
        panel.add(editDetailsButton);

        nameLabel = new JLabel("Name: " + currentStudent.getName());
        nameLabel.setFont(Constant.MAIN_FONT);
        nameLabel.setBounds(300, 100, 400, 30);
        panel.add(nameLabel);

        emailLabel = new JLabel("Email: " + currentStudent.getEmail());
        emailLabel.setFont(Constant.MAIN_FONT);
        emailLabel.setBounds(300, 140, 400, 30);
        panel.add(emailLabel);

        phoneLabel = new JLabel("Phone: " + currentStudent.getPhone());
        phoneLabel.setFont(Constant.MAIN_FONT);
        phoneLabel.setBounds(300, 180, 400, 30);
        panel.add(phoneLabel);

        creditsLabel = new JLabel("Credits Completed: " + currentStudent.getCreditsCompleted());
        creditsLabel.setFont(Constant.MAIN_FONT);
        creditsLabel.setBounds(300, 220, 400, 30);
        panel.add(creditsLabel);

        cgpaLabel = new JLabel("CGPA: " + currentStudent.getCgpa());
        cgpaLabel.setFont(Constant.MAIN_FONT);
        cgpaLabel.setBounds(300, 260, 400, 30);
        panel.add(cgpaLabel);

        enrolledCoursesLabel = new JLabel("Enrolled Courses: " + currentStudent.getEnrolledCourses());
        enrolledCoursesLabel.setFont(Constant.MAIN_FONT);
        enrolledCoursesLabel.setBounds(300, 300, 450, 30);
        panel.add(enrolledCoursesLabel);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == menuButton) {
            isMenuOpen = !isMenuOpen;
            menuPanel.setVisible(isMenuOpen);
        } else if (ae.getSource() == editAvatarButton) {
            editAvatar();
        } else if (ae.getSource() == editDetailsButton) {
            editDetails();
        } else if (ae.getSource() == registrationButton) {
            CourseRegistration reg = new CourseRegistration(currentStudent);
            reg.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == logoutButton) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            this.dispose();
        }
    }

    private void editAvatar() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Avatar Image");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        javax.swing.filechooser.FileNameExtensionFilter imageFilter = 
            new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(imageFilter);
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String studentImgDir = Constant.ASSET + "studentImg/";
                File dir = new File(studentImgDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                
                String fileName = currentStudent.getStudentId() + "_" + selectedFile.getName();
                String destPath = studentImgDir + fileName;
                Files.copy(selectedFile.toPath(), Paths.get(destPath), 
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                
                currentStudent.setAvatarFilename(fileName);
                
                StudentService service = new StudentService();
                service.updateStudent(currentStudent);
                
                avater = new ImageIcon(destPath);
                avaterLabel.setIcon(avater);
                
                JOptionPane.showMessageDialog(this, "Avatar updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error updating avatar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void editDetails() {
        JTextField nameField = new JTextField(currentStudent.getName());
        JTextField emailField = new JTextField(currentStudent.getEmail());
        JTextField phoneField = new JTextField(currentStudent.getPhone());

        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        form.add(new JLabel("Name:")); form.add(nameField);
        form.add(new JLabel("Email:")); form.add(emailField);
        form.add(new JLabel("Phone:")); form.add(phoneField);

        int option = JOptionPane.showConfirmDialog(this, form, "Edit Student Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String newName = nameField.getText().trim();
                String newEmail = emailField.getText().trim();
                String newPhone = phoneField.getText().trim();

                currentStudent.setName(newName);
                currentStudent.setEmail(newEmail);
                currentStudent.setPhone(newPhone);

                StudentService service = new StudentService();
                boolean ok = service.updateStudent(currentStudent);
                if (ok) {
                    nameLabel.setText("Name: " + currentStudent.getName());
                    emailLabel.setText("Email: " + currentStudent.getEmail());
                    phoneLabel.setText("Phone: " + currentStudent.getPhone());
                    JOptionPane.showMessageDialog(this, "Details updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update details.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error updating details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}
