

public class MyReportsFrame extends JFrame {

    public MyReportsFrame() {
        setTitle("My Reports");
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

        JLabel headerTitle = new JLabel("Lost & Found  •  My Reports");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JButton backTop = new JButton("← Back to Home");
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
        card.setPreferredSize(new Dimension(900, 520));

        // Card Header
        JPanel cardHeader = new JPanel(new BorderLayout());
        cardHeader.setBackground(Color.WHITE);
        cardHeader.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0,0,1,0, BORDER),
            new EmptyBorder(20, 25, 20, 25)
        ));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.WHITE);

        JLabel title = new JLabel("MY REPORTS");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(TEXT_DARK);

        JLabel subtitle = new JLabel("3 reports submitted by you");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(TEXT_GRAY);
        subtitle.setBorder(new EmptyBorder(4,0,0,0));

        titlePanel.add(title);
        titlePanel.add(subtitle);

        // small stats on right
        JPanel stats = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        stats.setBackground(Color.WHITE);
        stats.add(createMiniStat("Lost", "2", new Color(254,226,226), new Color(153,27,27)));
        stats.add(createMiniStat("Found", "1", new Color(219,234,254), new Color(30,64,175)));
        stats.add(createMiniStat("Returned", "1", new Color(220,252,231), new Color(22,101,52)));

        cardHeader.add(titlePanel, BorderLayout.WEST);
        cardHeader.add(stats, BorderLayout.EAST);
        card.add(cardHeader, BorderLayout.NORTH);

        // ===== TABLE =====
        String[] columns = {"Item", "Type", "Date", "Status", "Location"};
        Object[][] data = {
                {"Wallet - Black Leather", "Lost", "25/09/2026", "Lost", "Library Block"},
                {"ID Card - CS Dept", "Lost", "20/09/2026", "Returned", "Canteen"},
                {"Book - OOPS Notes", "Found", "22/09/2026", "Found", "Lab 3"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            public boolean isCellEditable(int row, int column) { return false; }
        };

        JTable table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(52);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0,0));
        table.setSelectionBackground(new Color(239,246,255));

        JTableHeader th = table.getTableHeader();
        th.setFont(new Font("Segoe UI", Font.BOLD, 12));
        th.setForeground(TEXT_GRAY);
        th.setBackground(new Color(249, 250, 251));
        th.setBorder(new MatteBorder(0,0,1,0, BORDER));
        th.setPreferredSize(new Dimension(0, 42));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new StatusRenderer());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        scrollPane.getViewport().setBackground(Color.WHITE);
        card.add(scrollPane, BorderLayout.CENTER);

        // ===== BOTTOM =====
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(249,250,251));
        bottomPanel.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(1,0,0,0, BORDER),
            new EmptyBorder(15, 25, 15, 25)
        ));

        JLabel hint = new JLabel("Select a report to view full details");
        hint.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        hint.setForeground(TEXT_GRAY);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        actions.setBackground(new Color(249,250,251));

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true), new EmptyBorder(9,18,9,18)
        ));
        backButton.setFocusPainted(false);

        JButton viewButton = new JButton("VIEW DETAILS");
        viewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        viewButton.setBackground(PRIMARY);
        viewButton.setForeground(Color.WHITE);
        viewButton.setBorder(new EmptyBorder(10, 20, 10, 20));
        viewButton.setFocusPainted(false);
        viewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        actions.add(backButton);
        actions.add(viewButton);

        bottomPanel.add(hint, BorderLayout.WEST);
        bottomPanel.add(actions, BorderLayout.EAST);
        card.add(bottomPanel, BorderLayout.SOUTH);

        wrapper.add(card);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createMiniStat(String label, String count, Color bg, Color fg) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));
        p.setBackground(bg);
        p.setBorder(new EmptyBorder(4,10,4,10));
        JLabel c = new JLabel(count);
        c.setFont(new Font("Segoe UI", Font.BOLD, 13));
        c.setForeground(fg);
        JLabel l = new JLabel(label);
        l.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        l.setForeground(fg);
        p.add(c); p.add(l);
        return p;
    }

    class StatusRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel base = new JLabel(value.toString());
            base.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            base.setOpaque(true);
            base.setBorder(new EmptyBorder(0,15,0,0));
            base.setBackground(isSelected ? new Color(239,246,255) : (row%2==0 ? Color.WHITE : new Color(249,250,251)));

            if (column == 3) { // Status badge
                JLabel badge = new JLabel(value.toString().toUpperCase());
                badge.setFont(new Font("Segoe UI", Font.BOLD, 11));
                badge.setOpaque(true);
                badge.setBorder(new EmptyBorder(5,12,5,12));
                badge.setHorizontalAlignment(SwingConstants.CENTER);
                String s = value.toString().toLowerCase();
                if (s.contains("lost")) {
                    badge.setBackground(new Color(254,226,226)); badge.setForeground(new Color(153,27,27));
                } else if (s.contains("found")) {
                    badge.setBackground(new Color(219,234,254)); badge.setForeground(new Color(30,64,175));
                } else {
                    badge.setBackground(new Color(220,252,231)); badge.setForeground(new Color(22,101,52));
                }
                JPanel wrap = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
                wrap.setBackground(base.getBackground());
                wrap.add(badge);
                return wrap;
            }
            if (column == 1) { // Type
                base.setForeground(new Color(107,114,128));
                base.setFont(new Font("Segoe UI", Font.BOLD, 12));
            }
            return base;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyReportsFrame().setVisible(true));
    }
}
