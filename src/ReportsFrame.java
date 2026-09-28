import javax.swing.*;
import java.awt.*;

public class ReportsFrame extends JFrame {

    public ReportsFrame() {

        setTitle("System Reports");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 70, 30, 70));

        JLabel title = new JLabel("SYSTEM REPORTS",
                SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel users = new JLabel("Total Users: 120",
                SwingConstants.CENTER);

        JLabel lost = new JLabel("Lost Items: 35",
                SwingConstants.CENTER);

        JLabel found = new JLabel("Found Items: 28",
                SwingConstants.CENTER);

        JLabel claims = new JLabel("Active Claims: 7",
                SwingConstants.CENTER);

        JLabel returned = new JLabel("Returned Items: 21",
                SwingConstants.CENTER);

        JButton refreshButton = new JButton("REFRESH");
        JButton backButton = new JButton("BACK");

        panel.add(title);
        panel.add(users);
        panel.add(lost);
        panel.add(found);
        panel.add(claims);
        panel.add(returned);

        JPanel buttons = new JPanel();
        buttons.add(refreshButton);
        buttons.add(backButton);

        add(panel, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReportsFrame().setVisible(true);
        });
    }
}
 