import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class WelcomeFrame extends JFrame {

    public WelcomeFrame() {
        setTitle("Lost & Found Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(37, 99, 235);
        Color TEXT_DARK = new Color(17, 24, 39);
        Color TEXT_GRAY = new Color(107, 114, 128);
        Color BORDER = new Color(229, 231, 235);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        // ===== NAV BAR =====
        JPanel nav = new JPanel(new BorderLayout());
        nav.setBackground(Color.WHITE);
        nav.setPreferredSize(new Dimension(0, 72));
        nav.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0,0,1,0, BORDER),
            new EmptyBorder(0, 40, 0, 40)
        ));

        JPanel navLeft = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        navLeft.setBackground(Color.WHITE);
        JLabel logoIcon = new JLabel("🎓");
        logoIcon.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        JLabel logoText = new JLabel("Lost & Found");
        logoText.setFont(new Font("Segoe UI", Font.BOLD, 18));
        logoText.setForeground(TEXT_DARK);
        navLeft.add(logoIcon);
        navLeft.add(logoText);

        JPanel navRight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
        navRight.setBackground(Color.WHITE);
        JLabel nav1 = new JLabel("How it works");
        nav1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        nav1.setForeground(TEXT_GRAY);
        JLabel nav2 = new JLabel("Contact Admin");
        nav2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        nav2.setForeground(TEXT_GRAY);
        JLabel campusBadge = new JLabel("College Campus • Live");
        campusBadge.setFont(new Font("Segoe UI", Font.BOLD, 11));
        campusBadge.setForeground(new Color(22,101,52));
        campusBadge.setBackground(new Color(220,252,231));
        campusBadge.setOpaque(true);
        campusBadge.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(134,239,172),1,true),
            new EmptyBorder(5,10,5,10)
        ));
        navRight.add(nav1);
        navRight.add(nav2);
        navRight.add(campusBadge);

        nav.add(navLeft, BorderLayout.WEST);
        nav.add(navRight, BorderLayout.EAST);
        add(nav, BorderLayout.NORTH);

        // ===== CENTER HERO =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);

        JPanel hero = new JPanel(new BorderLayout(50,0));
        hero.setBackground(BG_COLOR);
        hero.setPreferredSize(new Dimension(1100, 550));

        // LEFT CONTENT
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(BG_COLOR);
        left.setPreferredSize(new Dimension(550, 550));

        JLabel pill = new JLabel("✨ Trusted by 1200+ Students");
        pill.setFont(new Font("Segoe UI", Font.BOLD, 11));
        pill.setForeground(PRIMARY);
        pill.setBackground(new Color(219,234,254));
        pill.setOpaque(true);
        pill.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(147,197,253),1,true),
            new EmptyBorder(6,14,6,14)
        ));
        pill.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel title = new JLabel("<html><div style='width:500px'><span style='font-size:42px;font-weight:900;color:#111827;line-height:1.1'>LOST & FOUND<br>MANAGEMENT</span></div></html>");
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.setBorder(new EmptyBorder(18,0,0,0));

        JLabel subtitle = new JLabel("<html><div style='width:470px'><span style='font-size:16px;color:#4b5563;line-height:1.6'>Find it. Report it. Return it.<br>Your campus lost & found system — report lost items, help others find theirs, and get your belongings back securely verified by admin.</span></div></html>");
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitle.setBorder(new EmptyBorder(18,0,0,0));

        // Stats row
        JPanel stats = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        stats.setBackground(BG_COLOR);
        stats.setAlignmentX(Component.LEFT_ALIGNMENT);
        stats.setBorder(new EmptyBorder(28,0,0,0));
        stats.add(createHeroStat("1.2k+", "Items Found"));
        stats.add(Box.createHorizontalStrut(24));
        stats.add(createHeroStat("98%", "Return Rate"));
        stats.add(Box.createHorizontalStrut(24));
        stats.add(createHeroStat("24h", "Avg Return Time"));

        // Buttons
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        btnPanel.setBackground(BG_COLOR);
        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnPanel.setBorder(new EmptyBorder(32,0,0,0));

        JButton loginButton = new JButton("LOGIN →");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setBackground(PRIMARY);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(new EmptyBorder(14, 32, 14, 32));
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton registerButton = new JButton("CREATE ACCOUNT");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        registerButton.setBackground(Color.WHITE);
        registerButton.setForeground(TEXT_DARK);
        registerButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true),
            new EmptyBorder(13, 28, 13, 28)
        ));
        registerButton.setFocusPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnPanel.add(loginButton);
        btnPanel.add(registerButton);

        JPanel bottomNote = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        bottomNote.setBackground(BG_COLOR);
        bottomNote.setAlignmentX(Component.LEFT_ALIGNMENT);
        bottomNote.setBorder(new EmptyBorder(18,0,0,0));
        JLabel lock = new JLabel("🔒");
        JLabel note = new JLabel("Secured with College ID • Admin verified returns");
        note.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        note.setForeground(TEXT_GRAY);
        bottomNote.add(lock);
        bottomNote.add(note);

        left.add(pill);
        left.add(title);
        left.add(subtitle);
        left.add(stats);
        left.add(btnPanel);
        left.add(bottomNote);

        // RIGHT CARD - ILLUSTRATION
        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.WHITE);
        right.setBorder(new LineBorder(BORDER, 1, true));
        right.setPreferredSize(new Dimension(500, 520));

        JPanel rightTop = new JPanel(new GridBagLayout());
        rightTop.setBackground(new Color(239,246,255));
        rightTop.setPreferredSize(new Dimension(500, 200));
        rightTop.setBorder(new MatteBorder(0,0,1,0, BORDER));
        JLabel bigIcon = new JLabel("<html><center style='font-size:80px'>📦🔍✨</center><br><center style='font-size:13px;color:#4b5563'>Recover • Report • Return</center></html>");
        bigIcon.setHorizontalAlignment(SwingConstants.CENTER);
        rightTop.add(bigIcon);

        JPanel rightBottom = new JPanel();
        rightBottom.setLayout(new BoxLayout(rightBottom, BoxLayout.Y_AXIS));
        rightBottom.setBackground(Color.WHITE);
        rightBottom.setBorder(new EmptyBorder(20, 22, 20, 22));

        rightBottom.add(createFeature("📝", "Report in 30 seconds", "Lost or Found — just fill quick form"));
        rightBottom.add(Box.createVerticalStrut(14));
        rightBottom.add(createFeature("🔎", "Smart Search & Filters", "Find by category, location, date"));
        rightBottom.add(Box.createVerticalStrut(14));
        rightBottom.add(createFeature("✅", "Admin Verified Handover", "Safe return with ID proof check"));
        rightBottom.add(Box.createVerticalStrut(20));

        JPanel exitPanel = new JPanel(new BorderLayout());
        exitPanel.setBackground(new Color(249,250,251));
        exitPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true),
            new EmptyBorder(12,12,12,12)
        ));
        exitPanel.setMaximumSize(new Dimension(500, 55));
        JLabel exitText = new JLabel("Ready to exit?");
        exitText.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        exitText.setForeground(TEXT_GRAY);
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Segoe UI", Font.BOLD, 11));
        exitButton.setBackground(Color.WHITE);
        exitButton.setBorder(new LineBorder(BORDER,1,true));
        exitButton.setFocusPainted(false);
        exitButton.setPreferredSize(new Dimension(70,30));
        exitPanel.add(exitText, BorderLayout.WEST);
        exitPanel.add(exitButton, BorderLayout.EAST);
        rightBottom.add(exitPanel);

        right.add(rightTop, BorderLayout.NORTH);
        right.add(rightBottom, BorderLayout.CENTER);

        hero.add(left, BorderLayout.WEST);
        hero.add(right, BorderLayout.EAST);
        wrapper.add(hero);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createHeroStat(String num, String label) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(245,247,251));
        JLabel n = new JLabel(num);
        n.setFont(new Font("Segoe UI", Font.BOLD, 20));
        n.setForeground(new Color(17,24,39));
        JLabel l = new JLabel(label);
        l.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        l.setForeground(new Color(107,114,128));
        p.add(n); p.add(l);
        return p;
    }

    private JPanel createFeature(String icon, String title, String sub) {
        JPanel p = new JPanel(new BorderLayout(12,0));
        p.setBackground(Color.WHITE);
        p.setMaximumSize(new Dimension(500, 50));
        JLabel i = new JLabel(icon);
        i.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        i.setPreferredSize(new Dimension(40,40));
        i.setHorizontalAlignment(SwingConstants.CENTER);
        i.setBackground(new Color(239,246,255));
        i.setOpaque(true);
        i.setBorder(new LineBorder(new Color(191,219,254),1,true));
        JPanel txt = new JPanel();
        txt.setLayout(new BoxLayout(txt, BoxLayout.Y_AXIS));
        txt.setBackground(Color.WHITE);
        JLabel t = new JLabel(title);
        t.setFont(new Font("Segoe UI", Font.BOLD, 13));
        t.setForeground(new Color(17,24,39));
        JLabel s = new JLabel(sub);
        s.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        s.setForeground(new Color(107,114,128));
        txt.add(t); txt.add(Box.createVerticalStrut(2)); txt.add(s);
        p.add(i, BorderLayout.WEST);
        p.add(txt, BorderLayout.CENTER);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WelcomeFrame().setVisible(true));
    }
}
