import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class AdminFrame extends JFrame {

    public AdminFrame() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(37, 99, 235);
        Color BORDER = new Color(229, 231, 235);
        Color TEXT_DARK = new Color(17, 24, 39);
        Color TEXT_GRAY = new Color(107, 114, 128);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        // === HEADER ===
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setPreferredSize(new Dimension(0, 80));
        header.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

        JLabel headerTitle = new JLabel("Lost & Found  •  Admin Dashboard");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JButton logoutTop = new JButton("Logout");
        logoutTop.setFont(new Font("Segoe UI", Font.BOLD, 13));
        logoutTop.setForeground(Color.WHITE);
        logoutTop.setBackground(new Color(29, 78, 216));
        logoutTop.setBorder(new EmptyBorder(8, 18, 8, 18));
        logoutTop.setFocusPainted(false);
        logoutTop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        header.add(logoutTop, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);
        wrapper.setBorder(new EmptyBorder(40, 0, 40, 0));

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1, true),
            new EmptyBorder(40, 40, 40, 40)
        ));
        card.setPreferredSize(new Dimension(850, 620));
        card.setMaximumSize(new Dimension(850, 620));

        JLabel title = new JLabel("ADMIN DASHBOARD");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(TEXT_DARK);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel welcome = new JLabel("Welcome, Administrator  •  Manage the Lost & Found portal");
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        welcome.setForeground(TEXT_GRAY);
        welcome.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcome.setBorder(new EmptyBorder(5, 0, 30, 0));

        card.add(title);
        card.add(welcome);

        // ===== DASHBOARD BUTTONS - like website cards =====
        JPanel grid = new JPanel(new GridLayout(3, 1, 15, 15));
        grid.setBackground(Color.WHITE);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.setMaximumSize(new Dimension(770, 400));

        grid.add(createDashboardButton("MANAGE ITEMS", "Add, edit or remove lost & found items", new Color(37,99,235), "📦"));
        grid.add(createDashboardButton("REVIEW CLAIMS", "Approve or reject claims from students", new Color(16,185,129), "✓"));
        grid.add(createDashboardButton("VIEW REPORTS", "See statistics and activity logs", new Color(139,92,246), "📊"));

        card.add(grid);

        // Bottom logout (second option)
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
        bottomPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel logoutHint = new JLabel("Not you? ");
        logoutHint.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        logoutHint.setForeground(TEXT_GRAY);

        JButton logoutLink = new JButton("Logout");
        logoutLink.setFont(new Font("Segoe UI", Font.BOLD, 13));
        logoutLink.setForeground(PRIMARY);
        logoutLink.setBorder(null);
        logoutLink.setContentAreaFilled(false);
        logoutLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        bottomPanel.add(logoutHint);
        bottomPanel.add(logoutLink);
        card.add(bottomPanel);

        wrapper.add(card);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createDashboardButton(String title, String desc, Color accent, String iconText) {
        JPanel btn = new JPanel(new BorderLayout());
        btn.setBackground(Color.WHITE);
        btn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229,231,235), 1, true),
            new EmptyBorder(18, 20, 18, 20)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect like website
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(new Color(248, 250, 252));
                btn.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(accent, 1, true),
                    new EmptyBorder(18, 20, 18, 20)
                ));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(Color.WHITE);
                btn.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(229,231,235), 1, true),
                    new EmptyBorder(18, 20, 18, 20)
                ));
            }
        });

        // Left - Icon circle
        JPanel iconPanel = new JPanel(new GridBagLayout());
        iconPanel.setBackground(Color.WHITE);
        iconPanel.setPreferredSize(new Dimension(50, 50));
        JLabel icon = new JLabel(iconText);
        icon.setFont(new Font("Segoe UI", Font.BOLD, 20));
        icon.setForeground(accent);
        iconPanel.add(icon);

        // Center - Text
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);
        textPanel.setBorder(new EmptyBorder(0, 15, 0, 0));

        JLabel t = new JLabel(title);
        t.setFont(new Font("Segoe UI", Font.BOLD, 15));
        t.setForeground(new Color(17,24,39));

        JLabel d = new JLabel(desc);
        d.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        d.setForeground(new Color(107,114,128));

        textPanel.add(t);
        textPanel.add(Box.createVerticalStrut(3));
        textPanel.add(d);

        // Right - Arrow
        JLabel arrow = new JLabel("→");
        arrow.setFont(new Font("Segoe UI", Font.BOLD, 18));
        arrow.setForeground(new Color(156,163,175));

        btn.add(iconPanel, BorderLayout.WEST);
        btn.add(textPanel, BorderLayout.CENTER);
        btn.add(arrow, BorderLayout.EAST);

        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminFrame().setVisible(true));
    }
}
