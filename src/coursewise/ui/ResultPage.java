package coursewise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import coursewise.util.Constant;

public class ResultPage extends JFrame implements ActionListener {

    JPanel panel;
    JButton backButton;
    JButton resultBtn1, resultBtn2;

    public ResultPage() {
        super("Result | Course Wise");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("Course Results");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(300, 20, 250, 30);
        panel.add(title);

        /* ===== TABLE HEADER ===== */
        addHeader("Course Name", 80);
        addHeader("Course Code", 260);
        addHeader("Section", 420);
        addHeader("Action", 540);

        /* ===== ROW 1 ===== */
        addLabel("Data Structure", 80, 100);
        addLabel("CSE-220", 260, 100);
        addLabel("A", 420, 100);

        resultBtn1 = new JButton("Result");
        resultBtn1.setBounds(520, 95, 100, 30);
        resultBtn1.addActionListener(this);
        panel.add(resultBtn1);

        /* ===== ROW 2 ===== */
        addLabel("Database System", 80, 150);
        addLabel("CSE-310", 260, 150);
        addLabel("B", 420, 150);

        resultBtn2 = new JButton("Result");
        resultBtn2.setBounds(520, 145, 100, 30);
        resultBtn2.addActionListener(this);
        panel.add(resultBtn2);

        /* ===== BACK BUTTON ===== */
        backButton = new JButton("Back");
        backButton.setBounds(50, 400, 100, 35);
        backButton.setFont(Constant.MAIN_FONT);
        backButton.setBackground(Constant.PRIMARY_COLOR);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        panel.add(backButton);

        add(panel);
    }

    private void addHeader(String text, int x) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        lbl.setBounds(x, 70, 150, 25);
        panel.add(lbl);
    }

    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 150, 25);
        panel.add(lbl);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == resultBtn1 || ae.getSource() == resultBtn2) {
            showResultPopup();
        }

        else if (ae.getSource() == backButton) {
            AdminDashboard dashboard = new AdminDashboard();
            dashboard.setVisible(true);
            this.dispose();
        }
    }

    /* ===== POPUP WITH BLANK DATA ===== */
    private void showResultPopup() {

        String message =
                "Student Name: \n" +
                "Student ID: \n" +
                "Credit: \n" +
                "Completed Credit: \n" +
                "Course Result: ";

        JOptionPane.showMessageDialog(
                this,
                message,
                "Course Result",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
