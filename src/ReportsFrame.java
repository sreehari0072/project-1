import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ReportsFrame extends JFrame {

    public ReportsFrame() {
        setTitle("System Reports");
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

        JLabel headerTitle = new JLabel("Lost & Found  •  System Reports");
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

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(BORDER, 1, true));
        card.setPreferredSize(new Dimension(950, 640));

        // Card top bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);
        topBar.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0,0,1,0, BORDER),
            new EmptyBorder(20, 30, 20, 30)
        ));

        JLabel title = new JLabel("SYSTEM REPORTS");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(TEXT_DARK);

        JLabel subtitle = new JLabel("Overview of campus Lost & Found activity");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(TEXT_GRAY);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(3));
        titlePanel.add(subtitle);

        JButton refreshButton = new JButton("↻  Refresh");
        refreshButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        refreshButton.setBackground(PRIMARY);
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setBorder(new EmptyBorder(10, 20, 10, 20));
        refreshButton.setFocusPainted(false);
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        topBar.add(titlePanel, BorderLayout.WEST);
        topBar.add(refreshButton, BorderLayout.EAST);
        card.add(topBar);

        // ===== STATS GRID - like real website dashboard =====
        JPanel statsGrid = new JPanel(new GridLayout(2, 3, 20, 20));
        statsGrid.setBackground(Color.WHITE);
        statsGrid.setBorder(new EmptyBorder(25, 25, 25, 25));

        statsGrid.add(createStatCard("Total Users", "120", "+12% from last month", "👥", new Color(37,99,235), new Color(239,246,255)));
        statsGrid.add(createStatCard("Lost Items", "35", "8 reported today", "❗", new Color(239,68,68), new Color(254,226,226)));
        statsGrid.add(createStatCard("Found Items", "28", "5 found today", "✅", new Color(16,185,129), new Color(220,252,231)));
        statsGrid.add(createStatCard("Active Claims", "7", "2 pending approval", "📋", new Color(245,158,11), new Color(254,243,199)));
        statsGrid.add(createStatCard("Returned Items", "21", "75% success rate", "🎉", new Color(139,92,246), new Color(237,233,254)));
        statsGrid.add(createStatCard("Success Rate", "68%", "Overall return rate", "📈", new Color(6,182,212), new Color(207,250,254)));

        card.add(statsGrid);

        // Bottom bar
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(new Color(249,250,251));
        bottom.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(1,0,0,0, BORDER),
            new EmptyBorder(15, 25, 15, 25)
        ));

        JLabel updated = new JLabel("Last updated: Today, 08 Oct 2025 • 10:42 AM");
        updated.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        updated.setForeground(TEXT_GRAY);

        JButton backButton = new JButton("BACK TO DASHBOARD");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true),
            new EmptyBorder(9,18,9,18)
        ));

        bottom.add(updated, BorderLayout.WEST);
        bottom.add(backButton, BorderLayout.EAST);
        card.add(bottom);

        wrapper.add(card);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createStatCard(String label, String value, String footer, String icon, Color accent, Color lightBg) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229,231,235), 1, true),
            new EmptyBorder(18, 18, 18, 18)
        ));

        // Hover like website
        card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                card.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(accent, 1, true),
                    new EmptyBorder(18, 18, 18, 18)
                ));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                card.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(229,231,235), 1, true),
                    new EmptyBorder(18, 18, 18, 18)
                ));
            }
        });

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        JPanel iconBox = new JPanel(new GridBagLayout());
        iconBox.setBackground(lightBg);
        iconBox.setPreferredSize(new Dimension(44,44));
        iconBox.setBorder(new EmptyBorder(5,5,5,5));
        iconBox.add(iconLabel);

        JLabel trend = new JLabel("↗");
        trend.setFont(new Font("Segoe UI", Font.BOLD, 14));
        trend.setForeground(accent);

        header.add(iconBox, BorderLayout.WEST);
        header.add(trend, BorderLayout.EAST);
        header.setMaximumSize(new Dimension(300, 50));

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        valueLabel.setForeground(new Color(17,24,39));
        valueLabel.setBorder(new EmptyBorder(12,0,2,0));
        valueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel labelLabel = new JLabel(label.toUpperCase());
        labelLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        labelLabel.setForeground(new Color(107,114,128));
        labelLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel footerLabel = new JLabel(footer);
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footerLabel.setForeground(new Color(107,114,128));
        footerLabel.setBorder(new EmptyBorder(8,0,0,0));
        footerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // accent line at bottom
        JPanel line = new JPanel();
        line.setBackground(accent);
        line.setPreferredSize(new Dimension(0, 3));
        line.setMaximumSize(new Dimension(300, 3));
        line.setBorder(new EmptyBorder(0,0,0,0));

        card.add(header);
        card.add(valueLabel);
        card.add(labelLabel);
        card.add(footerLabel);
        card.add(Box.createVerticalStrut(12));
        card.add(line);

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReportsFrame().setVisible(true));
    }
}
