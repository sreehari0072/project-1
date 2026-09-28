import javax.swing.*;
import java.awt.*;

public class ManageItemsFrame extends JFrame {

    public ManageItemsFrame() {

        setTitle("Manage Items");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("MANAGE ITEMS", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        String[] columns = {"ID", "Item", "Type", "Status"};

        Object[][] data = {
                {"01", "Wallet", "Lost", "Lost"},
                {"02", "Phone", "Found", "Found"},
                {"03", "ID Card", "Lost", "Returned"},
                {"04", "Bag", "Found", "Claimed"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton updateButton = new JButton("UPDATE STATUS");
        JButton deleteButton = new JButton("DELETE ITEM");
        JButton backButton = new JButton("BACK");

        JPanel bottomPanel = new JPanel();

        bottomPanel.add(updateButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(backButton);

        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManageItemsFrame().setVisible(true);
        });
    }
}
