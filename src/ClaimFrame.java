import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ClaimFrame extends JFrame {

    public ClaimFrame() {
        setTitle("Claim Item");
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

        JLabel headerTitle = new JLabel("Lost & Found  •  Claim Item");
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

        JPanel main = new JPanel(new BorderLayout(20, 0));
        main.setBackground(BG_COLOR);
        main.setPreferredSize(new Dimension(950, 620));

        // ===== LEFT - ITEM CARD =====
        JPanel itemCard = new JPanel();
        itemCard.setLayout(new BoxLayout(itemCard, BoxLayout.Y_AXIS));
        itemCard.setBackground(Color.WHITE);
        itemCard.setBorder(new LineBorder(BORDER, 1, true));
        itemCard.setPreferredSize(new Dimension(300, 620));

        JPanel itemImagePanel = new JPanel(new GridBagLayout());
        itemImagePanel.setBackground(new Color(249,250,251));
        itemImagePanel.setPreferredSize(new Dimension(300, 180));
        itemImagePanel.setBorder(new MatteBorder(0,0,1,0, BORDER));
        
        JLabel imgIcon = new JLabel("👛");
        imgIcon.setFont(new Font("Segoe UI", Font.PLAIN, 64));
        itemImagePanel.add(imgIcon);
        itemCard.add(itemImagePanel);

        JPanel itemDetails = new JPanel();
        itemDetails.setLayout(new BoxLayout(itemDetails, BoxLayout.Y_AXIS));
        itemDetails.setBackground(Color.WHITE);
        itemDetails.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel itemName = new JLabel("Black Wallet");
        itemName.setFont(new Font("Segoe UI", Font.BOLD, 18));
        itemName.setForeground(TEXT_DARK);

        JLabel foundBadge = new JLabel("FOUND ITEM");
        foundBadge.setFont(new Font("Segoe UI", Font.BOLD, 10));
        foundBadge.setForeground(new Color(22,101,52));
        foundBadge.setBackground(new Color(220,252,231));
        foundBadge.setOpaque(true);
        foundBadge.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(134,239,172),1,true),
            new EmptyBorder(4,8,4,8)
        ));
        foundBadge.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel meta = new JPanel();
        meta.setLayout(new BoxLayout(meta, BoxLayout.Y_AXIS));
        meta.setBackground(Color.WHITE);
        meta.setBorder(new EmptyBorder(15,0,0,0));

        meta.add(createMetaRow("Category:", "Wallet"));
        meta.add(Box.createVerticalStrut(8));
        meta.add(createMetaRow("Found at:", "Library Block"));
        meta.add(Box.createVerticalStrut(8));
        meta.add(createMetaRow("Date:", "24/09/2026"));
        meta.add(Box.createVerticalStrut(8));
        meta.add(createMetaRow("ID:", "#F-1024"));

        JLabel warning = new JLabel("<html><div style='width:240px'>You must provide proof that this item belongs to you. False claims may lead to action.</div></html>");
        warning.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        warning.setForeground(new Color(153,27,27));
        warning.setBackground(new Color(254,226,226));
        warning.setOpaque(true);
        warning.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(252,165,165),1,true),
            new EmptyBorder(10,10,10,10)
        ));
        warning.setAlignmentX(Component.LEFT_ALIGNMENT);

        itemDetails.add(itemName);
        itemDetails.add(Box.createVerticalStrut(8));
        itemDetails.add(foundBadge);
        itemDetails.add(meta);
        itemDetails.add(Box.createVerticalStrut(20));
        itemDetails.add(warning);

        itemCard.add(itemDetails);
        main.add(itemCard, BorderLayout.WEST);

        // ===== RIGHT - CLAIM FORM =====
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(BORDER, 1, true));

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);
        topBar.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0,0,1,0, BORDER),
            new EmptyBorder(22, 28, 18, 28)
        ));

        JLabel title = new JLabel("CLAIM ITEM");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(TEXT_DARK);

        JLabel subtitle = new JLabel("Prove ownership - be specific");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(TEXT_GRAY);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(4));
        titlePanel.add(subtitle);

        JLabel secure = new JLabel("🔒 Secure Claim");
        secure.setFont(new Font("Segoe UI", Font.BOLD, 11));
        secure.setForeground(new Color(30,64,175));
        secure.setBackground(new Color(219,234,254));
        secure.setOpaque(true);
        secure.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(147,197,253),1,true),
            new EmptyBorder(6,12,6,12)
        ));

        topBar.add(titlePanel, BorderLayout.WEST);
        topBar.add(secure, BorderLayout.EAST);
        card.add(topBar);

        // Form
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        form.setBorder(new EmptyBorder(20, 28, 10, 28));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0; gbc.weightx = 1;

        JLabel itemLabel = new JLabel("Claiming Item: Black Wallet (#F-1024)");
        itemLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        itemLabel.setForeground(PRIMARY);
        itemLabel.setBackground(new Color(239,246,255));
        itemLabel.setOpaque(true);
        itemLabel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(191,219,254),1,true),
            new EmptyBorder(10,12,10,12)
        ));
        JPanel wrapItem = new JPanel(new BorderLayout());
        wrapItem.setBackground(Color.WHITE);
        wrapItem.setBorder(new EmptyBorder(0,0,5,0));
        wrapItem.add(itemLabel, BorderLayout.CENTER);
        form.add(wrapItem, gbc);

        form.add(createAreaField("Why is this yours?", "Explain how you lost it, when, where...", 3), gbc);
        form.add(createAreaField("Identifying Details (proof of ownership):", "Secret marks, contents inside wallet, bill amount, cards inside...", 4), gbc);

        JPanel attachPanel = new JPanel(new BorderLayout());
        attachPanel.setBackground(Color.WHITE);
        attachPanel.setBorder(new EmptyBorder(5,0,0,0));
        JLabel attachLabel = new JLabel("Upload ID Proof (Optional):");
        attachLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        attachLabel.setForeground(new Color(55,65,81));
        JPanel uploadBox = new JPanel(new GridBagLayout());
        uploadBox.setBackground(new Color(249,250,251));
        uploadBox.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true),
            new EmptyBorder(12,12,12,12)
        ));
        uploadBox.setPreferredSize(new Dimension(0, 52));
        JLabel uploadText = new JLabel("📎 Click to upload or drag file (JPG/PDF)");
        uploadText.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        uploadText.setForeground(TEXT_GRAY);
        uploadBox.add(uploadText);
        attachPanel.add(attachLabel, BorderLayout.NORTH);
        attachPanel.add(Box.createVerticalStrut(6));
        attachPanel.add(uploadBox, BorderLayout.CENTER);
        gbc.insets = new Insets(15,0,10,0);
        form.add(attachPanel, gbc);

        card.add(form);

        // Buttons
        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.setBackground(new Color(249,250,251));
        btnPanel.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(1,0,0,0, BORDER),
            new EmptyBorder(16, 28, 16, 28)
        ));

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true), new EmptyBorder(10,20,10,20)
        ));
        backButton.setFocusPainted(false);

        JPanel rightBtns = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightBtns.setBackground(new Color(249,250,251));

        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        clearButton.setBackground(Color.WHITE);
        clearButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER,1,true), new EmptyBorder(10,20,10,20)
        ));
        clearButton.setFocusPainted(false);

        JButton submitButton = new JButton("SUBMIT CLAIM");
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        submitButton.setBackground(PRIMARY);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(new EmptyBorder(11, 26, 11, 26));
        submitButton.setFocusPainted(false);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        rightBtns.add(clearButton);
        rightBtns.add(submitButton);

        btnPanel.add(backButton, BorderLayout.WEST);
        btnPanel.add(rightBtns, BorderLayout.EAST);
        card.add(btnPanel);

        main.add(card, BorderLayout.CENTER);
        wrapper.add(main);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createMetaRow(String k, String v) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.WHITE);
        p.setMaximumSize(new Dimension(300, 20));
        JLabel kl = new JLabel(k);
        kl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        kl.setForeground(new Color(107,114,128));
        JLabel vl = new JLabel(v);
        vl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        vl.setForeground(new Color(17,24,39));
        p.add(kl, BorderLayout.WEST);
        p.add(vl, BorderLayout.EAST);
        return p;
    }

    private JPanel createAreaField(String labelText, String placeholder, int rows) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(new EmptyBorder(0,0,5,0));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(55,65,81));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea area = new JTextArea(rows, 20);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(new LineBorder(new Color(209,213,219),1,true));
        scroll.setMaximumSize(new Dimension(1000, rows==3? 90 : 110));
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);

        p.add(label);
        p.add(Box.createVerticalStrut(6));
        p.add(scroll);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClaimFrame().setVisible(true));
    }
}