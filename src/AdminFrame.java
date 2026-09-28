import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {

    public AdminFrame() {

        setTitle("Admin Dashboard");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 70, 40, 70));

        JLabel title = new JLabel("ADMIN DASHBOARD", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel welcome = new JLabel("Welcome, Administrator",
                SwingConstants.CENTER);

        JButton manageItemsButton = new JButton("MANAGE ITEMS");
        JButton claimsButton = new JButton("REVIEW CLAIMS");
        JButton reportsButton = new JButton("VIEW REPORTS");
        JButton logoutButton = new JButton("LOGOUT");

        panel.add(title);
        panel.add(welcome);
        panel.add(manageItemsButton);
        panel.add(claimsButton);
        panel.add(reportsButton);

        JPanel bottom = new JPanel();
        bottom.add(logoutButton);

        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminFrame().setVisible(true);
        });
    }
}