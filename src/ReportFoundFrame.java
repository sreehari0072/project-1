import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReportFoundFrame extends JFrame {

    private final Color BLUE = new Color(37, 99, 235);
    private final Color BG = new Color(245, 248, 252);
    private final Color TEXT = new Color(31, 41, 55);
    private final Color MUTED = new Color(107, 114, 128);
    private final Color BORDER = new Color(209, 213, 219);

    private JTextField itemNameField;
    private JTextField locationField;
    private JTextField keptAtField;
    private JTextField contactField;

    private JTextArea descriptionArea;

    private JComboBox<String> categoryBox;

    public ReportFoundFrame() {

        setTitle("Report Found Item - Lost and Found");
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

        JLabel backLabel = new JLabel("← Back to Search");
        backLabel.setFont(new Font("Arial", Font.BOLD, 14));
        backLabel.setForeground(BLUE);
        backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                goToSearch();
            }
        });

        JLabel heading = new JLabel("REPORT A FOUND ITEM");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(TEXT);

        header.add(backLabel, BorderLayout.WEST);
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

        // ================= ITEM NAME =================

        formPanel.add(createLabel("Item Name"));

        itemNameField = new JTextField();
        styleTextField(itemNameField);
        formPanel.add(itemNameField);

        formPanel.add(Box.createVerticalStrut(12));

        // ================= CATEGORY =================

        formPanel.add(createLabel("Category"));

        String[] categories = {
            "Select Category",
            "Wallet",
            "ID Card",
            "Electronics",
            "Books",
            "Keys",
            "Clothing",
            "Accessories",
            "Other"
        };

        categoryBox = new JComboBox<>(categories);
        categoryBox.setFont(new Font("Arial", Font.PLAIN, 14));
        categoryBox.setForeground(TEXT);
        categoryBox.setBackground(Color.WHITE);
        categoryBox.setBorder(new LineBorder(BORDER, 1, true));
        categoryBox.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 40)
        );
        categoryBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        formPanel.add(categoryBox);

        formPanel.add(Box.createVerticalStrut(12));

        // ================= LOCATION =================

        formPanel.add(createLabel("Where Was the Item Found?"));

        locationField = new JTextField();
        styleTextField(locationField);
        formPanel.add(locationField);

        formPanel.add(Box.createVerticalStrut(12));

        // ================= DESCRIPTION =================

        formPanel.add(createLabel("Item Description"));

        descriptionArea = new JTextArea(3, 30);
        styleTextArea(descriptionArea);

        JScrollPane descriptionScroll =
                new JScrollPane(descriptionArea);

        styleScrollPane(descriptionScroll);

        descriptionScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        descriptionScroll.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 80)
        );

        formPanel.add(descriptionScroll);

        formPanel.add(Box.createVerticalStrut(12));

        // ================= KEPT AT =================

        formPanel.add(createLabel("Where Is the Item Kept?"));

        keptAtField = new JTextField();
        styleTextField(keptAtField);
        formPanel.add(keptAtField);

        formPanel.add(Box.createVerticalStrut(12));

        // ================= CONTACT =================

        formPanel.add(createLabel("Contact Information (Optional)"));

        contactField = new JTextField();
        styleTextField(contactField);
        formPanel.add(contactField);

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
        backButton.addActionListener(e -> goToSearch());

        JButton clearButton = new JButton("CLEAR");
        styleSecondaryButton(clearButton);
        clearButton.addActionListener(e -> clearForm());

        JButton submitButton = new JButton("SUBMIT FOUND ITEM");
        stylePrimaryButton(submitButton);
        submitButton.addActionListener(e -> submitItem());

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
        button.setPreferredSize(new Dimension(175, 40));
    }

    // ================= SECONDARY BUTTON =================

    private void styleSecondaryButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(BLUE);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(BLUE, 1, true));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(95, 40));
    }

    // ================= CLEAR FORM =================

    private void clearForm() {

        itemNameField.setText("");
        locationField.setText("");
        keptAtField.setText("");
        contactField.setText("");
        descriptionArea.setText("");
        categoryBox.setSelectedIndex(0);
    }

    // ================= SUBMIT ITEM =================

    private void submitItem() {

        String itemName = itemNameField.getText().trim();
        String category = (String) categoryBox.getSelectedItem();
        String location = locationField.getText().trim();
        String description = descriptionArea.getText().trim();
        String keptAt = keptAtField.getText().trim();
        String contact = contactField.getText().trim();

        // Validate required fields.

        if (itemName.isEmpty()
                || categoryBox.getSelectedIndex() == 0
                || location.isEmpty()
                || description.isEmpty()
                || keptAt.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all required fields.",
                    "Incomplete Form",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Generate the current date.

        String date = LocalDate.now().format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );

        // Create the new found item.

        SearchFrame.Item newItem = new SearchFrame.Item(
                itemName,
                category,
                location,
                "Found",
                description,
                date,
                keptAt,
                contact
        );

        // Add the item to the shared item list.

        SearchFrame.items.add(newItem);

        JOptionPane.showMessageDialog(
                this,
                "Found item reported successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Return to the search page.

        goToSearch();
    }

    // ================= NAVIGATION =================

    private void goToSearch() {

        new SearchFrame().setVisible(true);
        dispose();
    }

    // ================= TESTING =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ReportFoundFrame().setVisible(true);
        });
    }
}