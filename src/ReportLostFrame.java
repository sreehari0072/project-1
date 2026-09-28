

import javax.swing.*;
import java.awt.*;

public class ReportLostFrame extends JFrame {

    public ReportLostFrame() {

        setTitle("Report Lost Item");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("REPORT LOST ITEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel itemLabel = new JLabel("Item Name:");
        JTextField itemField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{"ID Card", "Electronics", "Books", "Bag",
                        "Wallet", "Keys", "Other"}
        );

        JLabel descriptionLabel = new JLabel("Description:");
        JTextArea descriptionArea = new JTextArea();

        JLabel locationLabel = new JLabel("Location Lost:");
        JTextField locationField = new JTextField();

        JLabel dateLabel = new JLabel("Date Lost:");
        JTextField dateField = new JTextField();

        JButton submitButton = new JButton("SUBMIT REPORT");
        JButton clearButton = new JButton("CLEAR");
        JButton backButton = new JButton("BACK");

        panel.add(title);
        panel.add(new JLabel());

        panel.add(itemLabel);
        panel.add(itemField);

        panel.add(categoryLabel);
        panel.add(categoryBox);

        panel.add(descriptionLabel);
        panel.add(new JScrollPane(descriptionArea));

        panel.add(locationLabel);
        panel.add(locationField);

        panel.add(dateLabel);
        panel.add(dateField);

        panel.add(submitButton);
        panel.add(clearButton);

        panel.add(backButton);
        panel.add(new JLabel());

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReportLostFrame().setVisible(true);
        });
    }
}