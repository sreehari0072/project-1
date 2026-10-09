import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class HomeFrame extends JFrame {

    public HomeFrame() {
        setTitle("Lost & Found - Home");
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

        JLabel headerTitle = new JLabel("Lost & Found Portal");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JPanel rightHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        rightHeader.setOpaque(false);

        JLabel userLabel = new JLabel("👤 Welcome, User!");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userLabel.setForeground(Color.WHITE);

        JButton logoutTop = new JButton("Logout");
        logoutTop.setFont(new Font("Segoe UI", Font.BOLD, 12));
        logoutTop.setBackground(new Color(29, 78, 216));
        logoutTop.setForeground(Color.WHITE);
        logoutTop.setBorder(new EmptyBorder(7, 16, 7, 16));
        logoutTop.setFocusPainted(false);

        rightHeader.add(userLabel);
        rightHeader.add(logoutTop);
        header.add(rightHeader, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);
        wrapper.setBorder(new EmptyBorder(40, 0, 40, 0));

        JPanel mainCard = new JPanel();
        mainCard.setLayout(new BoxLayout(mainCard, BoxLayout.Y_AXIS));
        mainCard.setBackground(Color.WHITE);
        mainCard.setBorder(new LineBorder(BORDER, 1, true));
        mainCard.setPreferredSize(new Dimension(900, 580));

        // Top banner inside card
        JPanel banner = new JPanel(new BorderLayout());
        banner.setBackground(Color.WHITE);
        banner.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0,0,1,0, BORDER),
            new EmptyBorder(30, 35, 25, 35)
        ));

        JLabel title = new JLabel("LOST & FOUND");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(TEXT_DARK);

        JLabel welcome = new JLabel("Find what you lost, return what you found - campus community portal");
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        welcome.setForeground(TEXT_GRAY);
        welcome.setBorder(new EmptyBorder(6,0,0,0));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(title);
        titlePanel.add(welcome);

        banner.add(titlePanel, BorderLayout.WEST);
        mainCard.add(banner);

        // ===== ACTION GRID =====
        JPanel grid = new JPanel(new GridLayout(2, 3, 20, 20));
        grid.setBackground(Color.WHITE);
        grid.setBorder(new EmptyBorder(30, 30, 30, 30));

        grid.add(createActionCard("REPORT LOST ITEM", "Lost something?", "📦", new Color(239,68,68), new Color(254,226,226)));
        grid.add(createActionCard("REPORT FOUND ITEM", "Found something?", "🔍", new Color(16,185,129), new Color(220,252,231)));
        grid.add(createActionCard("SEARCH ITEMS", "Browse all items", "🔎", new Color(37,99,235), new Color(219,234,254)));
        grid.add(createActionCard("MY REPORTS", "Your submissions", "📋", new Color(245,158,11), new Color(254,243,199)));
        grid.add(createActionCard("MY CLAIMS", "Track your claims", "📄", new Color(139,92,246), new Color(237,233,254)));
        grid.add(createActionCard("LOGOUT", "Exit portal", "🚪", new Color(107,114,128), new Color(243,244,246)));

        mainCard.add(grid);

        // Bottom hint
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(new Color(249,250,251));
        bottom.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(1,0,0,0, BORDER),
            new EmptyBorder(12, 30, 12, 30)
        ));
        JLabel hint = new JLabel("Tip: Report items with clear photos and location for faster recovery • 42 items returned this month");
        hint.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        hint.setForeground(TEXT_GRAY);
        bottom.add(hint, BorderLayout.WEST);
        mainCard.add(bottom);

        wrapper.add(mainCard);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createActionCard(String title, String subtitle, String icon, Color accent, Color lightBg) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229,231,235), 1, true),
            new EmptyBorder(20, 20, 20, 20)
        ));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect like website
        card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                card.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(accent, 2, true),
                    new EmptyBorder(19, 19, 19, 19)
                ));
                card.setBackground(new Color(249,250,251));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                card.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(229,231,235), 1, true),
                    new EmptyBorder(20, 20, 20, 20)
                ));
                card.setBackground(Color.WHITE);
            }
        });

        
