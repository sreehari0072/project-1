
import javax.swing.*;
import java.awt.*;

public class SearchFrame extends JFrame {

    public SearchFrame() {

        setTitle("Search Items");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel searchLabel = new JLabel("Search:");
        JTextField searchField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{"All", "ID Card", "Electronics", "Books",
                        "Bag", "Wallet", "Keys", "Other"}
        );

        JLabel statusLabel = new JLabel("Status:");
        JComboBox<String> statusBox = new JComboBox<>(
                new String[]{"All", "Lost", "Found", "Claimed", "Returned"}
        );

        JButton searchButton = new JButton("SEARCH");

        topPanel.add(searchLabel);
        topPanel.add(searchField);

        topPanel.add(categoryLabel);
        topPanel.add(categoryBox);

        topPanel.add(statusLabel);
        topPanel.add(statusBox);

        String[] columns = {"Item", "Category", "Location", "Status"};

        Object[][] data = {
                {"Black Wallet", "Wallet", "Canteen", "Found"},
                {"Samsung Phone", "Electronics", "Library", "Lost"},
                {"College ID", "ID Card", "Main Block", "Found"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton detailsButton = new JButton("VIEW DETAILS");
        JButton backButton = new JButton("BACK");

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(detailsButton);
        bottomPanel.add(backButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SearchFrame().setVisible(true);
        });
    }
}
