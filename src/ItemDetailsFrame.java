import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ItemDetailsFrame extends JFrame {

    private SearchFrame.Item item;

    private final Color BLUE = new Color(37, 99, 235);
    private final Color DARK_BLUE = new Color(30, 64, 175);
    private final Color BG = new Color(245, 248, 252);
    private final Color TEXT = new Color(31, 41, 55);
    private final Color MUTED = new Color(107, 114, 128);
    private final Color GREEN = new Color(22, 163, 74);

    public ItemDetailsFrame() {

        item = SearchFrame.selectedItem;

        if (item == null) {
            item = SearchFrame.items.get(0);
            SearchFrame.selectedItem = item;
        }

        setTitle("Item Details - Lost and Found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 750);
        setMinimumSize(new Dimension(900, 650));
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout());

        // ================= HEADER =================

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.setBorder(new EmptyBorder(18, 30, 18, 30));

        JLabel backTop = new JLabel("← Back to Search");
        backTop.setFont(new Font("Arial", Font.BOLD, 14));
        backTop.setForeground(BLUE);
        backTop.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backTop.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                goToSearch();
            }
        });

        JLabel heading = new JLabel("ITEM DETAILS");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(TEXT);

        header.add(backTop, BorderLayout.WEST);
        header.add(heading, BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);

        // ================= MAIN CONTENT =================

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BG);
        mainPanel.setBorder(new EmptyBorder(25, 35, 25, 35));

        JPanel card = new JPanel(new BorderLayout(25, 20));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(229, 231, 235), 1, true),
                new EmptyBorder(25, 25, 25, 25)
        ));

        card.setPreferredSize(new Dimension(950, 510));

        // -------- LEFT SIDE: ITEM INFORMATION --------

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JLabel itemHeading = new JLabel(item.name);
        itemHeading.setFont(new Font("Arial", Font.BOLD, 25));
        itemHeading.setForeground(TEXT);
        itemHeading.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel statusLabel = new JLabel(
                "● " + safe(item.status).toUpperCase()
        );
        statusLabel.setFont(new Font("Arial", Font.BOLD, 12));
        statusLabel.setForeground(
                safe(item.status).equalsIgnoreCase("Found")
                        ? GREEN : BLUE
        );
        statusLabel.setBorder(new EmptyBorder(8, 0, 15, 0));
        statusLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel descriptionHeading = new JLabel("DESCRIPTION");
        descriptionHeading.setFont(new Font("Arial", Font.BOLD, 13));
        descriptionHeading.setForeground(MUTED);
        descriptionHeading.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea descriptionArea = new JTextArea(
                safe(item.description)
        );
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setForeground(TEXT);
        descriptionArea.setBackground(Color.WHITE);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFocusable(false);
        descriptionArea.setRows(4);

        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        descriptionScroll.setBorder(null);
        descriptionScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        descriptionScroll.setPreferredSize(new Dimension(400, 95));
        descriptionScroll.setMaximumSize(new Dimension(450, 110));

        leftPanel.add(itemHeading);
        leftPanel.add(statusLabel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(descriptionHeading);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(descriptionScroll);
        leftPanel.add(Box.createVerticalStrut(20));

        leftPanel.add(createDetailRow("CATEGORY", safe(item.category)));
        leftPanel.add(createDetailRow("LOCATION", safe(item.location)));
        leftPanel.add(createDetailRow(
                safe(item.status).equalsIgnoreCase("Lost")
                        ? "DATE REPORTED" : "DATE FOUND",
                safe(item.date)
        ));

        leftPanel.add(Box.createVerticalStrut(10));

        JLabel note = new JLabel(
                "<html><div style='width:350px;'>"
                + "Please provide accurate identifying details "
                + "when submitting a claim."
                + "</div></html>"
        );
        note.setFont(new Font("Arial", Font.PLAIN, 13));
        note.setForeground(MUTED);
        note.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftPanel.add(note);

        // -------- RIGHT SIDE: ACTION PANEL --------

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(248, 250, 252));
        rightPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(229, 231, 235), 1, true),
                new EmptyBorder(22, 22, 22, 22)
        ));

        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(300, 400));

        JLabel actionHeading = new JLabel("NEXT STEP");
        actionHeading.setFont(new Font("Arial", Font.BOLD, 17));
        actionHeading.setForeground(TEXT);
        actionHeading.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel actionDescription = new JLabel(
                "<html><div style='width:230px;'>"
                + "If this item belongs to you, submit a claim "
                + "with details that help verify your ownership."
                + "</div></html>"
        );
        actionDescription.setFont(new Font("Arial", Font.PLAIN, 13));
        actionDescription.setForeground(MUTED);
        actionDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton claimButton = new JButton("CLAIM THIS ITEM →");
        claimButton.setFont(new Font("Arial", Font.BOLD, 13));
        claimButton.setForeground(Color.WHITE);
        claimButton.setBackground(BLUE);
        claimButton.setFocusPainted(false);
        claimButton.setBorderPainted(false);
        claimButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        claimButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        claimButton.setMaximumSize(new Dimension(260, 45));
        claimButton.setPreferredSize(new Dimension(260, 45));

        claimButton.addActionListener(e -> openClaimFrame());

        JButton backButton = new JButton("BACK TO SEARCH");
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        backButton.setForeground(BLUE);
        backButton.setBackground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBorder(new LineBorder(BLUE, 1, true));
        backButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        backButton.setMaximumSize(new Dimension(260, 45));
        backButton.setPreferredSize(new Dimension(260, 45));

        backButton.addActionListener(e -> goToSearch());

        rightPanel.add(actionHeading);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(actionDescription);
        rightPanel.add(Box.createVerticalStrut(25));
        rightPanel.add(claimButton);
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(backButton);
        rightPanel.add(Box.createVerticalStrut(25));

        JLabel infoLabel = new JLabel(
                "<html><div style='width:230px;'>"
                + "Keep your claim information accurate. "
                + "The administrator may contact you for verification."
                + "</div></html>"
        );
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        infoLabel.setForeground(MUTED);
        infoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        rightPanel.add(infoLabel);

        // -------- ADD PANELS TO CARD --------

        card.add(leftPanel, BorderLayout.CENTER);
        card.add(rightPanel, BorderLayout.EAST);

        mainPanel.add(card);
        add(mainPanel, BorderLayout.CENTER);

        // ================= FOOTER =================

        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(Color.WHITE);
        footer.setBorder(new EmptyBorder(12, 30, 12, 30));

        JLabel footerLabel = new JLabel(
                "College Lost and Found System"
        );
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        footerLabel.setForeground(MUTED);

        footer.add(footerLabel, BorderLayout.WEST);
        add(footer, BorderLayout.SOUTH);
    }

    // ================= DETAIL ROW =================

    private JPanel createDetailRow(String label, String value) {

        JPanel row = new JPanel(new BorderLayout(10, 5));
        row.setBackground(Color.WHITE);
        row.setBorder(new EmptyBorder(8, 0, 8, 0));
        row.setAlignmentX(Component.LEFT_ALIGNMENT);
        row.setMaximumSize(new Dimension(450, 50));

        JLabel labelText = new JLabel(label);
        labelText.setFont(new Font("Arial", Font.BOLD, 11));
        labelText.setForeground(MUTED);

        JLabel valueText = new JLabel(value);
        valueText.setFont(new Font("Arial", Font.PLAIN, 14));
        valueText.setForeground(TEXT);

        row.add(labelText, BorderLayout.WEST);
        row.add(valueText, BorderLayout.CENTER);

        return row;
    }

    // ================= BUTTON ACTIONS =================

    private void goToSearch() {
        new SearchFrame().setVisible(true);
        dispose();
    }

    private void openClaimFrame() {

        if (!safe(item.status).equalsIgnoreCase("Found")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Only found items can be claimed.",
                    "Cannot Submit Claim",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        SearchFrame.selectedItem = item;

        new ClaimFrame().setVisible(true);
        dispose();
    }

    private String safe(String value) {
        return value == null || value.trim().isEmpty()
                ? "Not available"
                : value;
    }

    // ================= TESTING =================

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ItemDetailsFrame().setVisible(true);
        });
    }
}