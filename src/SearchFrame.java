import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchFrame extends JFrame {

    // Shared item data for all four frames
    public static class Item {
        String name, category, location, status;
        String description, date, keptAt, contact;

        public Item(String name, String category, String location,
                    String status, String description, String date,
                    String keptAt, String contact) {
            this.name = name;
            this.category = category;
            this.location = location;
            this.status = status;
            this.description = description;
            this.date = date;
            this.keptAt = keptAt;
            this.contact = contact;
        }
    }

   public static class Claim {

    public String itemName;
    public String claimantName;
    public String contact;
    public String reason;
    public String details;

    public Claim(
            String itemName,
            String claimantName,
            String contact,
            String reason,
            String details) {

        this.itemName = itemName;
        this.claimantName = claimantName;
        this.contact = contact;
        this.reason = reason;
        this.details = details;
    }
}

    public static final List<Item> items = new ArrayList<>();
    public static final List<Claim> claims = new ArrayList<>();

    public static Item selectedItem;

    static {
        items.add(new Item(
            "Black Wallet - Leather", "Wallet", "Canteen", "Found",
            "Black leather wallet with identifying marks.",
            "25/09/2026", "Admin Office", ""
        ));

        items.add(new Item(
            "Samsung Phone S22 Ultra", "Electronics",
            "Library 2nd Floor", "Lost",
            "Samsung phone reported missing.",
            "24/09/2026", "", ""
        ));

        items.add(new Item(
            "College ID - CS Dept", "ID Card", "Main Block", "Found",
            "College ID card found in the main block.",
            "25/09/2026", "Security Office", ""
        ));
    }

    private JTextField keywordField;
    private JComboBox<String> categoryBox, statusBox;
    private JTable table;
    private DefaultTableModel model;
    private JLabel resultCount, pageInfo;
    private String activeFilter = "All";

    public SearchFrame() {
        setTitle("Search Items");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(37, 99, 235);
        Color BORDER = new Color(229, 231, 235);
        Color TEXT_DARK = new Color(17, 24, 39);
        Color TEXT_GRAY = new Color(107, 114, 128);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        // HEADER
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setPreferredSize(new Dimension(0, 80));
        header.setBorder(new EmptyBorder(0, 40, 0, 40));

        JLabel headerTitle = new JLabel("Lost & Found  •  Search Items");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JButton backTop = new JButton("← Back to Home");
        backTop.setFont(new Font("Segoe UI", Font.BOLD, 13));
        backTop.setForeground(Color.WHITE);
        backTop.setBackground(new Color(29, 78, 216));
        backTop.setBorder(new EmptyBorder(8, 18, 8, 18));
        backTop.setFocusPainted(false);

        backTop.addActionListener(e -> {
            new HomeFrame().setVisible(true);
            this.dispose();
        });

        header.add(backTop, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // WRAPPER
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(BG_COLOR);
        wrapper.setBorder(new EmptyBorder(25, 30, 25, 30));

        // FILTER CARD
        JPanel filterCard = new JPanel(new BorderLayout());
        filterCard.setBackground(Color.WHITE);
        filterCard.setBorder(new LineBorder(BORDER, 1, true));

        JPanel filterHeader = new JPanel(new BorderLayout());
        filterHeader.setBackground(Color.WHITE);
        filterHeader.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0, 0, 1, 0, BORDER),
            new EmptyBorder(16, 22, 16, 22)
        ));

        JLabel filterTitle = new JLabel("🔍 Search & Filter Items");
        filterTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        filterTitle.setForeground(TEXT_DARK);

        resultCount = new JLabel("3 results • Try different filters if not found");
        resultCount.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        resultCount.setForeground(TEXT_GRAY);

        filterHeader.add(filterTitle, BorderLayout.WEST);
        filterHeader.add(resultCount, BorderLayout.EAST);
        filterCard.add(filterHeader, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(new EmptyBorder(18, 22, 18, 22));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;

        keywordField = createStyledField();

        gbc.gridx = 0;
        gbc.weightx = 0.4;
        gbc.insets = new Insets(0, 0, 0, 8);
        topPanel.add(
            createFieldPanel("Search Keyword:", keywordField), gbc
        );

        categoryBox = new JComboBox<>(new String[]{
            "All", "ID Card", "Electronics", "Books",
            "Bag", "Wallet", "Keys", "Other"
        });

        gbc.gridx = 1;
        gbc.weightx = 0.25;
        gbc.insets = new Insets(0, 8, 0, 8);
        topPanel.add(createComboPanel("Category:", categoryBox), gbc);

        statusBox = new JComboBox<>(new String[]{
            "All", "Lost", "Found", "Claimed", "Returned"
        });

        gbc.gridx = 2;
        gbc.weightx = 0.2;
        gbc.insets = new Insets(0, 8, 0, 12);
        topPanel.add(createComboPanel("Status:", statusBox), gbc);

        JButton searchButton = new JButton("SEARCH");
        searchButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        searchButton.setBackground(PRIMARY);
        searchButton.setForeground(Color.WHITE);
        searchButton.setBorder(new EmptyBorder(12, 28, 12, 28));
        searchButton.setFocusPainted(false);
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridx = 3;
        gbc.weightx = 0;
        gbc.insets = new Insets(18, 0, 0, 0);
        topPanel.add(searchButton, gbc);

        searchButton.addActionListener(e -> searchItems());
        keywordField.addActionListener(e -> searchItems());
        categoryBox.addActionListener(e -> searchItems());
        statusBox.addActionListener(e -> searchItems());

        filterCard.add(topPanel, BorderLayout.CENTER);

        JPanel chipsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        chipsPanel.setBackground(new Color(249, 250, 251));
        chipsPanel.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(1, 0, 0, 0, BORDER),
            new EmptyBorder(12, 22, 12, 22)
        ));

        addChip(chipsPanel, "All (24)", "All", true);
        addChip(chipsPanel, "Found (12)", "Found", false);
        addChip(chipsPanel, "Lost (10)", "Lost", false);
        addChip(chipsPanel, "Wallet", "Wallet", false);
        addChip(chipsPanel, "ID Card", "ID Card", false);
        addChip(chipsPanel, "Electronics", "Electronics", false);
        addChip(chipsPanel, "Today", "Today", false);

        filterCard.add(chipsPanel, BorderLayout.SOUTH);
        wrapper.add(filterCard, BorderLayout.NORTH);

        // TABLE CARD
        JPanel tableCard = new JPanel(new BorderLayout());
        tableCard.setBackground(Color.WHITE);
        tableCard.setBorder(BorderFactory.createCompoundBorder(
            new EmptyBorder(20, 0, 0, 0),
            new LineBorder(BORDER, 1, true)
        ));

        String[] columns = {"Item", "Category", "Location", "Status"};

        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(54);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionBackground(new Color(239, 246, 255));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTableHeader th = table.getTableHeader();
        th.setFont(new Font("Segoe UI", Font.BOLD, 11));
        th.setForeground(TEXT_GRAY);
        th.setBackground(new Color(249, 250, 251));
        th.setBorder(new MatteBorder(0, 0, 1, 0, BORDER));
        th.setPreferredSize(new Dimension(0, 42));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i)
                .setCellRenderer(new StatusRenderer());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.getViewport().setBackground(Color.WHITE);
        tableCard.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(249, 250, 251));
        bottomPanel.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(1, 0, 0, 0, BORDER),
            new EmptyBorder(14, 22, 14, 22)
        ));

        pageInfo = new JLabel("Showing 0 items");
        pageInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        pageInfo.setForeground(TEXT_GRAY);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        actions.setBackground(new Color(249, 250, 251));

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1, true),
            new EmptyBorder(9, 18, 9, 18)
        ));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            new HomeFrame().setVisible(true);
            this.dispose();
        });

        JButton detailsButton = new JButton("VIEW DETAILS →");
        detailsButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        detailsButton.setBackground(PRIMARY);
        detailsButton.setForeground(Color.WHITE);
        detailsButton.setBorder(new EmptyBorder(10, 22, 10, 22));
        detailsButton.setFocusPainted(false);
        detailsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        detailsButton.addActionListener(e -> openSelectedItem());

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    openSelectedItem();
                }
            }
        });

        actions.add(backButton);
        actions.add(detailsButton);

        bottomPanel.add(pageInfo, BorderLayout.WEST);
        bottomPanel.add(actions, BorderLayout.EAST);
        tableCard.add(bottomPanel, BorderLayout.SOUTH);

        wrapper.add(tableCard, BorderLayout.CENTER);
        add(wrapper, BorderLayout.CENTER);

        refreshTable();
    }

    private void searchItems() {
        activeFilter = "All";
        refreshTable();
    }

    private void addChip(JPanel panel, String text,
                         String filter, boolean active) {
        JLabel chip = createChip(text, active);

        chip.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                activeFilter = filter;

                if (filter.equals("Found") || filter.equals("Lost")) {
                    statusBox.setSelectedItem(filter);
                    categoryBox.setSelectedItem("All");
                } else if (filter.equals("All")) {
                    statusBox.setSelectedItem("All");
                    categoryBox.setSelectedItem("All");
                    keywordField.setText("");
                } else if (filter.equals("Today")) {
                    statusBox.setSelectedItem("All");
                    categoryBox.setSelectedItem("All");
                } else {
                    categoryBox.setSelectedItem(filter);
                    statusBox.setSelectedItem("All");
                }

                refreshTable();
            }
        });

        panel.add(chip);
    }

    private void refreshTable() {
        model.setRowCount(0);

        String keyword = keywordField.getText().trim().toLowerCase();
        String category = (String) categoryBox.getSelectedItem();
        String status = (String) statusBox.getSelectedItem();

        for (Item item : items) {
            boolean matchesKeyword =
                keyword.isEmpty()
                || item.name.toLowerCase().contains(keyword)
                || item.category.toLowerCase().contains(keyword)
                || item.location.toLowerCase().contains(keyword)
                || item.description.toLowerCase().contains(keyword);

            boolean matchesCategory =
                category == null || category.equals("All")
                || item.category.equalsIgnoreCase(category);

            boolean matchesStatus =
                status == null || status.equals("All")
                || item.status.equalsIgnoreCase(status);

            boolean matchesChip =
                activeFilter.equals("All")
                || activeFilter.equals("Today")
                || item.category.equalsIgnoreCase(activeFilter)
                || item.status.equalsIgnoreCase(activeFilter);

            if (matchesKeyword && matchesCategory
                    && matchesStatus && matchesChip) {
                model.addRow(new Object[]{
                    item.name, item.category,
                    item.location, item.status
                });
            }
        }

        resultCount.setText(model.getRowCount() + " matching results");
        pageInfo.setText("Showing " + model.getRowCount() + " items");
    }

    public void refreshSearchResults() {
        refreshTable();
    }

    private void openSelectedItem() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(
                this,
                "Please select an item first.",
                "No Item Selected",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        String itemName = model.getValueAt(selectedRow, 0).toString();

        for (Item item : items) {
            if (item.name.equals(itemName)) {
                selectedItem = item;
                break;
            }
        }

        if (selectedItem != null) {
            new ItemDetailsFrame().setVisible(true);
            dispose();
        }
    }

    private void showHomeMessage() {
        JOptionPane.showMessageDialog(
            this,
            "The Home frame is not included in these four files.",
            "Home Screen",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private JTextField createStyledField() {
        JTextField f = new JTextField();
        f.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        f.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(209, 213, 219), 1, true),
            new EmptyBorder(10, 12, 10, 12)
        ));
        f.setPreferredSize(new Dimension(0, 42));
        return f;
    }

    private JPanel createFieldPanel(String labelText, JTextField field) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);

        JLabel l = new JLabel(labelText);
        l.setFont(new Font("Segoe UI", Font.BOLD, 11));
        l.setForeground(new Color(55, 65, 81));

        p.add(l);
        p.add(Box.createVerticalStrut(6));
        p.add(field);

        return p;
    }

    private JPanel createComboPanel(String labelText,
                                    JComboBox<String> box) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);

        JLabel l = new JLabel(labelText);
        l.setFont(new Font("Segoe UI", Font.BOLD, 11));
        l.setForeground(new Color(55, 65, 81));

        box.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        box.setBackground(Color.WHITE);
        box.setBorder(new LineBorder(
            new Color(209, 213, 219), 1, true
        ));
        box.setMaximumSize(new Dimension(1000, 42));

        p.add(l);
        p.add(Box.createVerticalStrut(6));
        p.add(box);

        return p;
    }

    private JLabel createChip(String text, boolean active) {
        JLabel chip = new JLabel(text);
        chip.setFont(new Font("Segoe UI", Font.BOLD, 11));
        chip.setOpaque(true);
        chip.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(
                active ? new Color(37, 99, 235)
                       : new Color(229, 231, 235), 1, true
            ),
            new EmptyBorder(6, 12, 6, 12)
        ));
        chip.setBackground(
            active ? new Color(37, 99, 235) : Color.WHITE
        );
        chip.setForeground(
            active ? Color.WHITE : new Color(55, 65, 81)
        );
        chip.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return chip;
    }

    class StatusRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            JLabel base = new JLabel(value.toString());
            base.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            base.setOpaque(true);
            base.setBorder(new EmptyBorder(0, 15, 0, 0));

            base.setBackground(
                isSelected ? new Color(239, 246, 255)
                    : (row % 2 == 0
                        ? Color.WHITE : new Color(249, 250, 251))
            );

            if (column == 3) {
                JLabel badge = new JLabel(value.toString().toUpperCase());
                badge.setFont(new Font("Segoe UI", Font.BOLD, 10));
                badge.setOpaque(true);
                badge.setBorder(new EmptyBorder(5, 10, 5, 10));

                if (value.toString().equalsIgnoreCase("Found")) {
                    badge.setBackground(new Color(220, 252, 231));
                    badge.setForeground(new Color(22, 101, 52));
                } else {
                    badge.setBackground(new Color(254, 226, 226));
                    badge.setForeground(new Color(153, 27, 27));
                }

                JPanel wrap = new JPanel(
                    new FlowLayout(FlowLayout.LEFT, 15, 10)
                );
                wrap.setBackground(base.getBackground());
                wrap.add(badge);

                return wrap;
            }

            if (column == 0) {
                base.setFont(new Font("Segoe UI", Font.BOLD, 13));
            }

            return base;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new SearchFrame().setVisible(true)
        );
    }
}
