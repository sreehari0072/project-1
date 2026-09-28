

import javax.swing.*;
import java.awt.*;

public class MyReportsFrame extends JFrame {

    public MyReportsFrame() {

        setTitle("My Reports");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("MY REPORTS", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        String[] columns = {"Item", "Type", "Date", "Status"};

        Object[][] data = {
                {"Wallet", "Lost", "25/09/2026", "Lost"},
                {"ID Card", "Lost", "20/09/2026", "Returned"},
                {"Book", "Found", "22/09/2026", "Found"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton viewButton = new JButton("VIEW DETAILS");
        JButton backButton = new JButton("BACK");

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(viewButton);
        bottomPanel.add(backButton);

        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MyReportsFrame().setVisible(true);
        });
    }
}