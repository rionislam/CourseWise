package coursewise.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentList extends JFrame implements ActionListener {

    JTable table;
    DefaultTableModel model;
    JButton backButton;

    public StudentList() {
        super("Student List | Course Wise");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

     
        JLabel title = new JLabel("All Students", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

       
        String[] columns = {"Name", "ID", "Mobile", "Email"};
        model = new DefaultTableModel(columns, 0);

        
        model.addRow(new Object[]{"", "", "", ""});

        table = new JTable(model);
        table.setRowHeight(25);

        add(new JScrollPane(table), BorderLayout.CENTER);

      
        backButton = new JButton("Back");
        backButton.setBackground(new Color(52, 152, 219));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.addActionListener(this);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            AdminDashboard dashboard = new AdminDashboard();
            dashboard.setVisible(true);
            this.dispose();
        }
    }

 
    //public static void main(String[] args) {
      //  new StudentList().setVisible(true);
   // }
}
