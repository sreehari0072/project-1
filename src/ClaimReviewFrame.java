import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ClaimReviewFrame extends JFrame {

    public ClaimReviewFrame() {
        setTitle("Claim Review");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(37, 99, 235);
        Color BORDER = new Color(229, 231, 235);
        Color TEXT_DARK = new Color(17, 24, 39);
        Color TEXT_GRAY = new Color(107, 114, 128);
        Color SUCCESS = new Color(16, 185, 129);
        Color DANGER = new Color(239, 68, 68);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        // ===== HEADER =====
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setPreferredSize(new Dimension(0, 80));
        header.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
        
        JLabel headerTitle = new JLabel("Lost & Found  •  Claim Review");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);
        
        JButton backTop = new JButton("← Back to Claims");
        backTop.setFont(new Font("Segoe UI", Font.BOLD, 13));
        backTop.setForeground(Color.WHITE);
        backTop.setBackground(new Color(29, 78, 216));
        backTop.setBorder(new EmptyBorder(8, 18, 8, 18));
        backTop.setFocusPainted(false);
        header.add(backTop, BorderLayout.EAST);
        
        add(header, BorderLayout.NORTH);

        // ===== CENTER WRAPPER =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);
        wrapper.setBorder(new EmptyBorder(40, 0, 40, 0));

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1, true),
            new EmptyBorder(35, 40, 35, 40)
        ));
        card.setPreferredSize(new Dimension(850, 680));
        card.setMaximumSize(new Dimension(850, 680));

        // Title row with badge
        JPanel titleRow = new JPanel(new BorderLayout());
        titleRow.setBackground(Color.WHITE);
        titleRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleRow.setMaximumSize(new Dimension(770, 40));

        JLabel title = new JLabel("CLAIM REVIEW");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(TEXT_DARK);

        JLabel badge = new JLabel("PENDING");
        badge.setFont(new Font("Segoe UI", Font.BOLD, 11));
        badge.setForeground(new Color(146, 64, 14));
        badge.setBackground(new Color(254, 243, 199));
        badge.setOpaque(true);
        badge.setBorder(new EmptyBorder(4, 12, 4, 12));

        titleRow.add(title, BorderLayout.WEST);
        titleRow.add(badge, BorderLayout.EAST);
        card.add(titleRow);

        // Claim ID
        JLabel claimIdLabel = new JLabel("Claim ID: CL101  •  Submitted 2 hours ago");
        claimIdLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        claimIdLabel.setForeground(TEXT_GRAY);
        claimIdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        claimIdLabel.setBorder(new EmptyBorder(5, 0, 25, 0));
        card.add(claimIdLabel);

        // ===== INFO GRID - like website =====
        JPanel infoGrid = new JPanel(new GridLayout(1, 2, 15, 15));
        infoGrid.setBackground(Color.WHITE);
        infoGrid.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoGrid.setMaximumSize(new Dimension(770, 100));
        infoGrid.setBorder(new EmptyBorder(0,0,25,0));

        infoGrid.add(createInfoBox("Item", "Black Wallet", "Found on 08-10-2025", PRIMARY));
        infoGrid.add(createInfoBox("Claimed By", "Student 102", "CSE, 3rd Sem", new Color(107,114,128)));

        card.add(infoGrid);

        // ===== DETAILS =====
        card.add(createDetailSection("Reason for Claim", "It has my college ID inside. My name is John and ID No is CS2021-102. You can verify inside the wallet.", TEXT_DARK));
        card.add(Box.createVerticalStrut(20));
        card.add(createDetailSection("Additional Details", "Small scratch on the left side. Contains 2 cards and some cash. The wallet is slightly faded on the corner.", TEXT_DARK));

        // Evidence note
        JPanel note = new JPanel(new BorderLayout());
        note.setBackground(new Color(239, 246, 255));
        note.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(191,219,254),1,true),
            new EmptyBorder(12,16,12,16)
        ));
        note.setAlignmentX(Component.LEFT_ALIGNMENT);
        note.setMaximumSize(new Dimension(770, 50));
        
        JLabel noteLabel = new JLabel("ℹ  Verify the college ID mentioned before approving the claim.");
        noteLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        noteLabel.setForeground(new Color(30,64,175));
        note.add(noteLabel, BorderLayout.CENTER);
        
        card.add(Box.createVerticalStrut(25));
        card.add(note);

        // ===== BUTTONS =====
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        btnPanel.setBackground(Color.WHITE);
        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnPanel.setBorder(new EmptyBorder(30,0,0,0));

        JButton approve = new JButton("✓  APPROVE CLAIM");
        approve.setFont(new Font("Segoe UI", Font.BOLD, 14));
        approve.setBackground(SUCCESS);
        approve.setForeground(Color.WHITE);
        approve.setBorder(new EmptyBorder(12, 28, 12, 28));
        approve.setFocusPainted(false);
        approve.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton reject = new JButton("✕  REJECT CLAIM");
        reject.setFont(new Font("Segoe UI", Font.BOLD, 14));
        reject.setBackground(Color.WHITE);
        reject.setForeground(DANGER);
        reject.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(DANGER, 1, true),
            new EmptyBorder(11, 22, 11, 22)
        ));
        reject.setFocusPainted(false);
        reject.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton back = new JButton("Back");
        back.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        back.setBackground(Color.WHITE);
        back.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1, true),
            new EmptyBorder(11, 22, 11, 22)
        ));
        back.setFocusPainted(false);

        btnPanel.add(approve);
        btnPanel.add(reject);
        btnPanel.add(back);
        
        card.add(btnPanel);

        wrapper.add(card);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createInfoBox(String label, String value, String sub, Color accent) {
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setBackground(new Color(249, 250, 251));
        box.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229,231,235),1,true),
            new EmptyBorder(15, 18, 15, 18)
        ));

        JLabel l = new JLabel(label.toUpperCase());
        l.setFont(new Font("Segoe UI", Font.BOLD, 11));
        l.setForeground(new Color(107,114,128));

        JLabel v = new JLabel(value);
        v.setFont(new Font("Segoe UI", Font.BOLD, 16));
        v.setForeground(accent);

        JLabel s = new JLabel(sub);
        s.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        s.setForeground(new Color(107,114,128));

        box.add(l);
        box.add(Box.createVerticalStrut(4));
        box.add(v);
        box.add(Box.createVerticalStrut(2));
        box.add(s);
        return box;
    }

    private JPanel createDetailSection(String heading, String content, Color dark) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.setMaximumSize(new Dimension(770, 120));

        JLabel h = new JLabel(heading);
        h.setFont(new Font("Segoe UI", Font.BOLD, 13));
        h.setForeground(new Color(55,65,81));
        h.setAlignmentX(Component.LEFT_ALIGNMENT);
        h.setBorder(new EmptyBorder(0,0,8,0));

        JTextArea c = new JTextArea(content);
        c.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        c.setLineWrap(true);
        c.setWrapStyleWord(true);
        c.setEditable(false);
        c.setBackground(new Color(249,250,251));
        c.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229,231,235),1,true),
            new EmptyBorder(10,12,10,12)
        ));
        c.setAlignmentX(Component.LEFT_ALIGNMENT);

        p.add(h);
        p.add(c);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClaimReviewFrame().setVisible(true));
    }
}
