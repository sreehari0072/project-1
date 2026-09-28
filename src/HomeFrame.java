

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {

    public HomeFrame() {

        setTitle("Lost & Found - Home");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        JLabel title = new JLabel("LOST & FOUND", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel welcome = new JLabel("Welcome, User!", SwingConstants.CENTER);

        JButton reportLostButton = new JButton("REPORT LOST ITEM");
        JButton reportFoundButton = new JButton("REPORT FOUND ITEM");

        JButton searchButton = new JButton("SEARCH ITEMS");
        JButton reportsButton = new JButton("MY REPORTS");

        JButton claimsButton = new JButton("MY CLAIMS");
        JButton logoutButton = new JButton("LOGOUT");

        panel.add(title);
        panel.add(welcome);

        panel.add(reportLostButton);
        panel.add(reportFoundButton);

        panel.add(searchButton);
        panel.add(reportsButton);

        panel.add(claimsButton);
        panel.add(logoutButton);

        panel.add(new JLabel());
        panel.add(new JLabel());

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HomeFrame().setVisible(true);
        });
    }
}