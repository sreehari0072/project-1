import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;

public class ManageItemsFrame extends JFrame {

    public ManageItemsFrame() {
        setTitle("Manage Items");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(37, 99, 235);
        Color BORDER = new Color(229, 231, 235);
        Color TEXT_DARK = new Color(17, 24, 39);
        Color TEXT_GRAY = new Color(107, 114, 128);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        // ===== HEADER =====
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setPreferredSize(new Dimension(0, 80));
        header.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

        JLabel headerTitle = new JLabel("Lost & Found  •  Manage Items");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JButton backTop = new JButton("← Back to Dashboard");
        backTop.setFont(new Font("Segoe UI", Font.BOLD, 13));
        backTop.setForeground(Color.WHITE);
        backTop.setBackground(new Color(29, 78, 216));
        backTop.setBorder(new EmptyBorder(8, 18, 8, 18));
        backTop.setFocusPainted(false);
        header.add(backTop, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);
        wrapper.setBorder(new EmptyBorder(30, 0, 30, 0));

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(BORDER, 1, true));
        card.setPreferredSize(new Dimension(950, 600));

        // Card Header - Title + Search like website
        JPanel cardHeader = new JPanel(new BorderLayout());
        cardHeader.setBackground(Color.WHITE);
        cardHeader.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0,0,1,0, BORDER),
            new EmptyBorder(20, 25, 20, 25)
        ));

        JLabel title = new JLabel("MANAGE ITEMS");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(TEXT_DARK);

        JLabel count = new JLabel("4 items");
        count.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        count.setForeground(TEXT_GRAY);
        count.setBorder(new EmptyBorder(5,0,0,0));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(title);
        titlePanel.add(count);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        searchPanel.setBackground(Color.WHITE);

        JTextField search = new JTextField("Search items...");
        search.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        search.setForeground(Color.GRAY);
        search.setPreferredSize(new Dimension(200, 38));
        search.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1, true),
            new EmptyBorder(5,12,5,12)
        ));

        JButton filterBtn = new JButton("Filter");
        filterBtn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        filterBtn.setBackground(Color.WHITE);
        filterBtn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true), new EmptyBorder(7,14,7,14)
        ));

        searchPanel.add(search);
        searchPanel.add(filterBtn);

        cardHeader.add(titlePanel, BorderLayout.WEST);
        cardHeader.add(searchPanel, BorderLayout.EAST);
        card.add(cardHeader, BorderLayout.NORTH);

        // ===== TABLE - website styled =====
        String[] columns = {"ID", "Item Name", "Type", "Status", "Date"};
        Object[][] data = {
                {"#01", "Wallet", "Lost", "Lost", "08 Oct 2025"},
                {"#02", "iPhone 13 - Blue", "Found", "Found", "07 Oct 2025"},
                {"#03", "College ID Card", "Lost", "Returned", "06 Oct 2025"},
                {"#04", "Black Backpack", "Found", "Claimed", "05 Oct 2025"},
                {"#05", "Water Bottle - Steel", "Lost", "Lost", "04 Oct 2025"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            public boolean isCellEditable(int row, int column) { return false; }
        };

        JTable table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(48);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0,0));
        table.setSelectionBackground(new Color(239,246,255));
        table.setSelectionForeground(TEXT_DARK);

        // Header style like website
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableHeader.setForeground(TEXT_GRAY);
        tableHeader.setBackground(new Color(249, 250, 251));
        tableHeader.setBorder(new MatteBorder(0,0,1,0, BORDER));
        tableHeader.setPreferredSize(new Dimension(0, 42));

        // Center align and status colors
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        centerRenderer.setBorder(new EmptyBorder(0,15,0,0));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new StatusRenderer());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        scrollPane.getViewport().setBackground(Color.WHITE);
        card.add(scrollPane, BorderLayout.CENTER);

        // ===== BOTTOM BUTTONS - like website action bar =====
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(249, 250, 251));
        bottomPanel.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(1,0,0,0, BORDER),
            new EmptyBorder(15, 25, 15, 25)
        ));

        JLabel hint = new JLabel("Select an item to update or delete");
        hint.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        hint.setForeground(TEXT_GRAY);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        actions.setBackground(new Color(249, 250, 251));

        JButton updateButton = new JButton("UPDATE STATUS");
        updateButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        updateButton.setBackground(PRIMARY);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBorder(new EmptyBorder(10, 20, 10, 20));
        updateButton.setFocusPainted(false);
        updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton deleteButton = new JButton("DELETE ITEM");
        deleteButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        deleteButton.setBackground(Color.WHITE);
        deleteButton.setForeground(new Color(239,68,68));
        deleteButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(252,165,165),1,true),
            new EmptyBorder(9,18,9,18)
        ));
        deleteButton.setFocusPainted(false);

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true),
            new EmptyBorder(9,18,9,18)
        ));
        backButton.setFocusPainted(false);

        actions.add(backButton);
        actions.add(deleteButton);
        actions.add(updateButton);

        bottomPanel.add(hint, BorderLayout.WEST);
        bottomPanel.add(actions, BorderLayout.EAST);
        card.add(bottomPanel, BorderLayout.SOUTH);

        wrapper.add(card);
        add(wrapper, BorderLayout.CENTER);
    }

    // Custom renderer to make status look like website badges
    class StatusRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel(value.toString());
            label.setOpaque(true);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label.setBorder(new EmptyBorder(0,15,0,0));

            if (isSelected) {
                label.setBackground(new Color(239,246,255));
            } else {
                label.setBackground(row % 2 == 0 ? Color.WHITE : new Color(249,250,251));
            }

            // Status badge column
            if (column == 3) {
                JLabel badge = new JLabel(value.toString().toUpperCase());
                badge.setFont(new Font("Segoe UI", Font.BOLD, 11));
                badge.setOpaque(true);
                badge.setBorder(new EmptyBorder(4,10,4,10));
                badge.setHorizontalAlignment(SwingConstants.CENTER);

                String status = value.toString().toLowerCase();
                if (status.contains("lost")) {
                    badge.setBackground(new Color(254,226,226));
                    badge.setForeground(new Color(153,27,27));
                } else if (status.contains("found")) {
                    badge.setBackground(new Color(219,234,254));
                    badge.setForeground(new Color(30,64,175));
                } else if (status.contains("returned")) {
                    badge.setBackground(new Color(220,252,231));
                    badge.setForeground(new Color(22,101,52));
                } else {
                    badge.setBackground(new Color(243,244,246));
                    badge.setForeground(new Color(55,65,81));
                }
                
                JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 8));
                p.setBackground(label.getBackground());
                p.add(badge);
                return p;
            }
            
            return label;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManageItemsFrame().setVisible(true));
    }
}
