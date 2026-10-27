import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ClaimFrame extends JFrame {

    private final Color BLUE = new Color(37, 99, 235);
    private final Color BG = new Color(245, 248, 252);
    private final Color TEXT = new Color(31, 41, 55);
    private final Color MUTED = new Color(107, 114, 128);
    private final Color BORDER = new Color(209, 213, 219);

    private JTextField nameField;
    private JTextField contactField;
    private JTextArea reasonArea;
    private JTextArea detailsArea;

    private JLabel itemLabel;

    private SearchFrame.Item selectedItem;

    public ClaimFrame() {

        selectedItem = SearchFrame.selectedItem;

        if (selectedItem == null) {
            selectedItem = SearchFrame.items.get(0);
            SearchFrame.selectedItem = selectedItem;
        }

        setTitle("Submit Claim - Lost and Found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setMinimumSize(new Dimension(800, 650));
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

        JLabel heading = new JLabel("SUBMIT A CLAIM");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(TEXT);

        header.add(backTop, BorderLayout.WEST);
        header.add(heading, BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);

        // ================= MAIN PANEL =================

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BG);
        mainPanel.setBorder(new EmptyBorder(20, 30, 20, 30));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(new CompoundBorder(
                new LineBorder(BORDER, 1, true),
                new EmptyBorder(25, 30, 25, 30)
        ));

        formPanel.setPreferredSize(new Dimension(750, 570));

        // -------- ITEM INFORMATION --------

        JLabel itemHeading = new JLabel("Item Details");
        itemHeading.setFont(new Font("Arial", Font.BOLD, 18));
        itemHeading.setForeground(TEXT);
        itemHeading.setAlignmentX(Component.LEFT_ALIGNMENT);

        itemLabel = new JLabel(
                "<html><b>Selected Item:</b> "
                + escapeHTML(selectedItem.name)
                + "</html>"
        );

        itemLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        itemLabel.setForeground(BLUE);
        itemLabel.setBorder(new EmptyBorder(10, 0, 18, 0));
        itemLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        formPanel.add(itemHeading);
        formPanel.add(itemLabel);

        // -------- CLAIMANT NAME --------

        formPanel.add(createLabel("Your Name"));

        nameField = new JTextField();
        styleTextField(nameField);
        formPanel.add(nameField);

        formPanel.add(Box.createVerticalStrut(12));

        // -------- CONTACT INFORMATION --------

        formPanel.add(createLabel("Contact Information"));

        contactField = new JTextField();
        styleTextField(contactField);
        formPanel.add(contactField);

        formPanel.add(Box.createVerticalStrut(12));

        // -------- REASON FOR CLAIM --------

        formPanel.add(createLabel("Reason for Claim"));

        reasonArea = new JTextArea(3, 30);
        styleTextArea(reasonArea);

        JScrollPane reasonScroll = new JScrollPane(reasonArea);
        styleScrollPane(reasonScroll);
        reasonScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        reasonScroll.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 75)
        );

        formPanel.add(reasonScroll);

        formPanel.add(Box.createVerticalStrut(12));

        // -------- IDENTIFICATION DETAILS --------

        formPanel.add(createLabel("Additional Identifying Details"));

        detailsArea = new JTextArea(3, 30);
        styleTextArea(detailsArea);

        JScrollPane detailsScroll = new JScrollPane(detailsArea);
        styleScrollPane(detailsScroll);
        detailsScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        detailsScroll.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 75)
        );

        formPanel.add(detailsScroll);

        formPanel.add(Box.createVerticalStrut(20));

        // ================= BUTTONS =================

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.RIGHT, 12, 0)
        );
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 50)
        );

        JButton backButton = new JButton("BACK");
        styleSecondaryButton(backButton);

        backButton.addActionListener(e -> goToDetails());

        JButton clearButton = new JButton("CLEAR");
        styleSecondaryButton(clearButton);

        clearButton.addActionListener(e -> clearForm());

        JButton submitButton = new JButton("SUBMIT CLAIM");
        stylePrimaryButton(submitButton);

        submitButton.addActionListener(e -> submitClaim());

        buttonPanel.add(backButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(submitButton);

        formPanel.add(buttonPanel);

        mainPanel.add(formPanel);
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

    // ================= LABEL =================

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(TEXT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(new EmptyBorder(0, 0, 6, 0));

        return label;
    }

    // ================= TEXT FIELD STYLE =================

    private void styleTextField(JTextField field) {

        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(TEXT);
        field.setBackground(Color.WHITE);
        field.setBorder(new CompoundBorder(
                new LineBorder(BORDER, 1, true),
                new EmptyBorder(8, 10, 8, 10)
        ));

        field.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 40)
        );

        field.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    // ================= TEXT AREA STYLE =================

    private void styleTextArea(JTextArea area) {

        area.setFont(new Font("Arial", Font.PLAIN, 14));
        area.setForeground(TEXT);
        area.setBackground(Color.WHITE);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(new EmptyBorder(8, 10, 8, 10));
    }

    private void styleScrollPane(JScrollPane scrollPane) {

        scrollPane.setBorder(new LineBorder(BORDER, 1, true));
        scrollPane.setBackground(Color.WHITE);
    }

    // ================= PRIMARY BUTTON =================

    private void stylePrimaryButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(BLUE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(150, 40));
    }

    // ================= SECONDARY BUTTON =================

    private void styleSecondaryButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(BLUE);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(BLUE, 1, true));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(100, 40));
    }

    // ================= CLEAR FORM =================

    private void clearForm() {

        nameField.setText("");
        contactField.setText("");
        reasonArea.setText("");
        detailsArea.setText("");
    }

    // ================= SUBMIT CLAIM =================

    private void submitClaim() {

        String claimantName = nameField.getText().trim();
        String contact = contactField.getText().trim();
        String reason = reasonArea.getText().trim();
        String details = detailsArea.getText().trim();

        if (claimantName.isEmpty()
                || contact.isEmpty()
                || reason.isEmpty()
                || details.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all the fields.",
                    "Incomplete Form",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (!selectedItem.status.equalsIgnoreCase("Found")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Only found items can be claimed.",
                    "Cannot Submit Claim",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Save the claim in the shared list.
        SearchFrame.claims.add(
                new SearchFrame.Claim(
                        selectedItem.name,
                        claimantName,
                        contact,
                        reason,
                        details
                )
        );

        JOptionPane.showMessageDialog(
                this,
                "Your claim has been submitted successfully!",
                "Claim Submitted",
                JOptionPane.INFORMATION_MESSAGE
        );

        goToDetails();
    }

    // ================= NAVIGATION =================

    private void goToSearch() {

        new SearchFrame().setVisible(true);
        dispose();
    }

    private void goToDetails() {

        SearchFrame.selectedItem = selectedItem;

        new ItemDetailsFrame().setVisible(true);
        dispose();
    }

    // ================= HTML ESCAPING =================

    private String escapeHTML(String text) {

        if (text == null) {
            return "";
        }

        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;");
    }

    // ================= TESTING =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ClaimFrame().setVisible(true);
        });
    }
}