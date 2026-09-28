
import javax.swing.*;
import java.awt.*;

public class ItemDetailsFrame extends JFrame {

    public ItemDetailsFrame() {

        setTitle("Item Details");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel title = new JLabel("ITEM DETAILS");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel item = new JLabel("Item: Black Wallet");
        JLabel category = new JLabel("Category: Wallet");
        JLabel description = new JLabel("Description: Black leather wallet");
        JLabel location = new JLabel("Location: College Canteen");
        JLabel date = new JLabel("Date: 25/09/2026");
        JLabel status = new JLabel("Status: FOUND");

        JButton claimButton = new JButton("CLAIM ITEM");
        JButton backButton = new JButton("BACK");

        item.setAlignmentX(Component.CENTER_ALIGNMENT);
        category.setAlignmentX(Component.CENTER_ALIGNMENT);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        location.setAlignmentX(Component.CENTER_ALIGNMENT);
        date.setAlignmentX(Component.CENTER_ALIGNMENT);
        status.setAlignmentX(Component.CENTER_ALIGNMENT);
        claimButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(30));
        panel.add(item);
        panel.add(Box.createVerticalStrut(10));
        panel.add(category);
        panel.add(Box.createVerticalStrut(10));
        panel.add(description);
        panel.add(Box.createVerticalStrut(10));
        panel.add(location);
        panel.add(Box.createVerticalStrut(10));
        panel.add(date);
        panel.add(Box.createVerticalStrut(10));
        panel.add(status);
        panel.add(Box.createVerticalStrut(30));
        panel.add(claimButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(backButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ItemDetailsFrame().setVisible(true);
        });
    }
}
