import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ItemDetailsFrame extends JFrame {

    public ItemDetailsFrame() {
        setTitle("Item Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(37, 99, 235);
        Color BORDER = new Color(229, 231, 235);
        Color TEXT_DARK = new Color(17, 24, 39);
        Color TEXT_GRAY = new Color(107, 114, 128);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        // ==== HEADER ====
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setPreferredSize(new Dimension(0, 80));
        header.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

        JLabel headerTitle = new JLabel("Lost & Found  •  Item Details");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JButton backTop = new JButton("← Back to Search");
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

        JPanel main = new JPanel(new BorderLayout(25, 0));
        main.setBackground(BG_COLOR);
        main.setPreferredSize(new Dimension(960, 600));

        // ===== LEFT - IMAGE & ACTIONS =====
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(Color.WHITE);
        left.setBorder(new LineBorder(BORDER, 1, true));
        left.setPreferredSize(new Dimension(380, 600));

        JPanel imagePanel = new JPanel(new GridBagLayout());
        imagePanel.setBackground(new Color(249,250,251));
        imagePanel.setPreferredSize(new Dimension(380, 300));
        imagePanel.setBorder(new MatteBorder(0,0,1,0, BORDER));
        
        JLabel bigIcon = new JLabel("👛");
        bigIcon.setFont(new Font("Segoe UI", Font.PLAIN, 96));
        imagePanel.add(bigIcon);
        left.add(imagePanel);

        JPanel leftContent = new JPanel();
        leftContent.setLayout(new BoxLayout(leftContent, BoxLayout.Y_AXIS));
        leftContent.setBackground(Color.WHITE);
        leftContent.setBorder(new EmptyBorder(20, 22, 20, 22));

        JLabel idLabel = new JLabel("ITEM ID: #F-1024");
        idLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        idLabel.setForeground(TEXT_GRAY);
        idLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel itemTitle = new JLabel("Black Wallet");
        itemTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        itemTitle.setForeground(TEXT_DARK);
        itemTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        itemTitle.setBorder(new EmptyBorder(6,0,0,0));

        // Status pills
        JPanel pills = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        pills.setBackground(Color.WHITE);
        pills.setAlignmentX(Component.LEFT_ALIGNMENT);
        pills.setBorder(new EmptyBorder(12,0,0,0));

        JLabel foundPill = new JLabel("● FOUND");
        foundPill.setFont(new Font("Segoe UI", Font.BOLD, 11));
        foundPill.setForeground(new Color(22,101,52));
        foundPill.setBackground(new Color(220,252,231));
        foundPill.setOpaque(true);
        foundPill.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(134,239,172),1,true), new EmptyBorder(5,10,5,10)
        ));

        JLabel verified = new JLabel("Verified by Admin");
        verified.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        verified.setForeground(new Color(30,64,175));
        verified.setBackground(new Color(219,234,254));
        verified.setOpaque(true);
        verified.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(147,197,253),1,true), new EmptyBorder(5,10,5,10)
        ));

        pills.add(foundPill);
        pills.add(verified);

        JPanel trustBox = new JPanel(new BorderLayout());
        trustBox.setBackground(new Color(249,250,251));
        trustBox.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true), new EmptyBorder(12,12,12,12)
        ));
        trustBox.setMaximumSize(new Dimension(400, 70));

        JLabel trust = new JLabel("<html><b style='color:#111827'>🔒 Safe Return Process</b><br><span style='color:#6b7280;font-size:11px'>Item is secured at Admin Office. Claim requires ID proof verification.</span></html>");
        trust.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        trustBox.add(trust, BorderLayout.CENTER);

        leftContent.add(idLabel);
        leftContent.add(itemTitle);
        leftContent.add(pills);
        leftContent.add(Box.createVerticalStrut(18));
        leftContent.add(trustBox);
        leftContent.add(Box.createVerticalGlue());

        // Buttons inside left
        JButton claimButton = new JButton("CLAIM THIS ITEM  →");
        claimButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        claimButton.setBackground(PRIMARY);
        claimButton.setForeground(Color.WHITE);
        claimButton.setBorder(new EmptyBorder(13,0,13,0));
        claimButton.setFocusPainted(false);
        claimButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        claimButton.setMaximumSize(new Dimension(400, 46));
        claimButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton backButton = new JButton("BACK TO SEARCH");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true), new EmptyBorder(11,0,11,0)
        ));
        backButton.setFocusPainted(false);
        backButton.setMaximumSize(new Dimension(400, 42));
        backButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftContent.add(claimButton);
        leftContent.add(Box.createVerticalStrut(10));
        leftContent.add(backButton);

        left.add(leftContent);
        main.add(left, BorderLayout.WEST);

        // ===== RIGHT - DETAILS =====
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBackground(Color.WHITE);
        right.setBorder(new LineBorder(BORDER, 1, true));

        JPanel rightHeader = new JPanel(new BorderLayout());
        rightHeader.setBackground(Color.WHITE);
        rightHeader.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0,0,1,0, BORDER), new EmptyBorder(20,25,20,25)
        ));

        JLabel detTitle = new JLabel("ITEM DETAILS");
        detTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        detTitle.setForeground(TEXT_DARK);

        JLabel lastUpdate = new JLabel("Last updated: 25/09/2026 • 2 claims pending");
        lastUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lastUpdate.setForeground(TEXT_GRAY);

        JPanel rt = new JPanel();
        rt.setLayout(new BoxLayout(rt, BoxLayout.Y_AXIS));
        rt.setBackground(Color.WHITE);
        rt.add(detTitle);
        rt.add(Box.createVerticalStrut(3));
        rt.add(lastUpdate);

        rightHeader.add(rt, BorderLayout.WEST);
        right.add(rightHeader);

        JPanel detailsList = new JPanel();
        detailsList.setLayout(new BoxLayout(detailsList, BoxLayout.Y_AXIS));
        detailsList.setBackground(Color.WHITE);
        detailsList.setBorder(new EmptyBorder(10,25,10,25));

        detailsList.add(createDetailRow("Item Name:", "Black Wallet", "👛"));
        detailsList.add(createDetailRow("Category:", "Wallet / Personal Item", "📦"));
        detailsList.add(createDetailRow("Description:", "Black leather wallet, has 2 cards inside and some cash. Slight scratch on corner.", "📝"));
        detailsList.add(createDetailRow("Location Found:", "College Canteen - Table near counter", "📍"));
        detailsList.add(createDetailRow("Date Found:", "25/09/2026 at 2:30 PM", "📅"));
        detailsList.add(createDetailRow("Found By:", "Reported by Student - ID: S-2041", "👤"));
        detailsList.add(createDetailRow("Status:", "FOUND - Available for Claim", "✅"));

        // Divider
        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(1000,1));
        sep.setForeground(BORDER);
        detailsList.add(Box.createVerticalStrut(15));
        detailsList.add(sep);
        detailsList.add(Box.createVerticalStrut(15));

        // How to claim
        JPanel howTo = new JPanel(new BorderLayout());
        howTo.setBackground(new Color(239,246,255));
        howTo.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(191,219,254),1,true), new EmptyBorder(14,14,14,14)
        ));
        howTo.setMaximumSize(new Dimension(1000, 90));
        JLabel howToLabel = new JLabel("<html><b style='color:#1e40af'>How to claim?</b><br><span style='color:#4b5563'>1. Click Claim Item  2. Provide proof of ownership  3. Admin will verify and contact you within 24h</span></html>");
        howToLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        howTo.add(howToLabel, BorderLayout.CENTER);

        detailsList.add(howTo);

        right.add(detailsList);

        main.add(right, BorderLayout.CENTER);
        wrapper.add(main);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createDetailRow(String key, String value, String icon) {
        JPanel row = new JPanel(new BorderLayout(12,0));
        row.setBackground(Color.WHITE);
        row.setBorder(new EmptyBorder(12,0,12,0));
        row.setMaximumSize(new Dimension(1000, 80));

        JLabel iconL = new JLabel(icon);
        iconL.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        iconL.setPreferredSize(new Dimension(30,30));

        JPanel text = new JPanel();
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
        text.setBackground(Color.WHITE);

        JLabel k = new JLabel(key);
        k.setFont(new Font("Segoe UI", Font.BOLD, 11));
        k.setForeground(TEXT_GRAY);

        JLabel v = new JLabel("<html><div style='width:380px'>"+value+"</div></html>");
        v.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        v.setForeground(new Color(17,24,39));
        v.setBorder(new EmptyBorder(3,0,0,0));

        text.add(k);
        text.add(v);

        row.add(iconL, BorderLayout.WEST);
        row.add(text, BorderLayout.CENTER);

        return row;
    }

    final Color TEXT_GRAY = new Color(107, 114, 128);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ItemDetailsFrame().setVisible(true));
    }
}
