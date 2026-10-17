import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterFrame extends JFrame {

    private JTextField nameField;
    private JTextField collegeIdField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JComboBox<String> roleBox;
    private JCheckBox agree;

    public RegisterFrame() {

        setTitle("Create Account");
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
        header.setPreferredSize(new Dimension(0, 70));
        header.setBorder(
            BorderFactory.createEmptyBorder(0, 40, 0, 40)
        );

        JLabel headerTitle = new JLabel("Lost & Found Portal");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JLabel campus = new JLabel("New User • Create Account");
        campus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        campus.setForeground(new Color(191, 219, 254));
        header.add(campus, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Color.WHITE);
        main.setBorder(new LineBorder(BORDER, 1, true));
        main.setPreferredSize(new Dimension(950, 620));

        // ===== LEFT - FORM =====
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(Color.WHITE);
        left.setBorder(new EmptyBorder(30, 40, 25, 40));

        JLabel title = new JLabel("CREATE ACCOUNT");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(TEXT_DARK);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle = new JLabel(
            "Join campus lost & found community - secure & verified"
        );
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(TEXT_GRAY);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitle.setBorder(new EmptyBorder(6, 0, 20, 0));

        left.add(title);
        left.add(subtitle);

        // ===== FORM GRID =====
        JPanel formGrid = new JPanel(
            new GridLayout(3, 2, 16, 16)
        );
        formGrid.setBackground(Color.WHITE);
        formGrid.setMaximumSize(new Dimension(1000, 170));
        formGrid.setAlignmentX(Component.LEFT_ALIGNMENT);

        nameField = new JTextField();
        collegeIdField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        roleBox = new JComboBox<>(
            new String[]{"Student", "Staff", "Admin"}
        );
        roleBox.setFocusable(true);

        formGrid.add(
            createField("Full Name:", nameField, "John Doe")
        );
        formGrid.add(
            createField("College ID:", collegeIdField, "CS21-045")
        );
        formGrid.add(
            createField(
                "Email Address:",
                emailField,
                "john@college.edu"
            )
        );
        formGrid.add(
            createComboField("Role:", roleBox)
        );
        formGrid.add(
            createField(
                "Password:",
                passwordField,
                "••••••••"
            )
        );
        formGrid.add(
            createField(
                "Confirm Password:",
                confirmPasswordField,
                "••••••••"
            )
        );

        left.add(formGrid);
        left.add(Box.createVerticalStrut(20));

        // ===== TERMS =====
        JPanel terms = new JPanel(new BorderLayout());
        terms.setBackground(Color.WHITE);
        terms.setMaximumSize(new Dimension(1000, 30));

        agree = new JCheckBox("I agree to Terms & Privacy Policy");
        agree.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        agree.setBackground(Color.WHITE);
        agree.setForeground(TEXT_GRAY);

        terms.add(agree, BorderLayout.WEST);
        left.add(terms);
        left.add(Box.createVerticalStrut(20));

        // ===== BUTTONS =====
        JPanel btns = new JPanel(new GridLayout(1, 2, 12, 0));
        btns.setBackground(Color.WHITE);
        btns.setMaximumSize(new Dimension(1000, 46));
        btns.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton backButton = new JButton("BACK TO LOGIN");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        backButton.setBackground(new Color(249, 250, 251));
        backButton.setBorder(new LineBorder(BORDER, 1, true));
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton registerButton = new JButton("CREATE ACCOUNT →");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        registerButton.setBackground(PRIMARY);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        registerButton.setFocusPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btns.add(backButton);
        btns.add(registerButton);
        left.add(btns);

        // ===== LOGIN LINK =====
        JLabel hasAcc = new JLabel(
            "<html><center>Already have an account? " +
            "<span style='color:#2563eb;font-weight:bold'>" +
            "Login here</span></center></html>"
        );
        hasAcc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        hasAcc.setForeground(TEXT_GRAY);
        hasAcc.setAlignmentX(Component.CENTER_ALIGNMENT);
        hasAcc.setBorder(new EmptyBorder(16, 0, 0, 0));
        hasAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));

        left.add(hasAcc);

        // ===== RIGHT - BENEFITS PANEL =====
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBackground(new Color(239, 246, 255));
        right.setPreferredSize(new Dimension(360, 620));
        right.setBorder(
            BorderFactory.createCompoundBorder(
                new MatteBorder(0, 1, 0, 0, BORDER),
                new EmptyBorder(35, 30, 35, 30)
            )
        );

        JLabel rightIcon = new JLabel("🛡️");
        rightIcon.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        rightIcon.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel rightTitle = new JLabel(
            "<html><div style='width:280px'>" +
            "<span style='font-size:20px;font-weight:bold;" +
            "color:#111827'>Secure & Verified Community</span>" +
            "<br><br>" +
            "<span style='font-size:13px;color:#4b5563;" +
            "line-height:1.6'>Your College ID is verified by admin " +
            "to prevent false claims and keep items safe.</span>" +
            "</div></html>"
        );
        rightTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightTitle.setBorder(new EmptyBorder(15, 0, 25, 0));

        right.add(rightIcon);
        right.add(rightTitle);

        right.add(createBenefit(
            "📦", "Report Lost & Found",
            "Post items in under 30 seconds"
        ));
        right.add(Box.createVerticalStrut(14));

        right.add(createBenefit(
            "🔍", "Smart Search",
            "Find items by category, location, date"
        ));
        right.add(Box.createVerticalStrut(14));

        right.add(createBenefit(
            "✅", "Verified Return",
            "Admin verified handover process"
        ));
        right.add(Box.createVerticalStrut(14));

        right.add(createBenefit(
            "🔔", "Instant Alerts",
            "Get notified when your item is found"
        ));

        right.add(Box.createVerticalGlue());

        JPanel trustBox = new JPanel(new BorderLayout());
        trustBox.setBackground(Color.WHITE);
        trustBox.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(191, 219, 254), 1, true),
                new EmptyBorder(12, 12, 12, 12)
            )
        );
        trustBox.setMaximumSize(new Dimension(300, 70));

        JLabel trust = new JLabel(
            "<html><b style='color:#1e40af'>🔒 Your data is safe</b>" +
            "<br><span style='color:#6b7280;font-size:11px'>" +
            "We never share your College ID or email outside campus portal." +
            "</span></html>"
        );
        trust.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        trustBox.add(trust, BorderLayout.CENTER);
        trustBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        right.add(trustBox);

        main.add(left, BorderLayout.CENTER);
        main.add(right, BorderLayout.EAST);

        wrapper.add(main);
        add(wrapper, BorderLayout.CENTER);

        // ===== ENTER KEY NAVIGATION =====

        // Full Name -> College ID
        nameField.addActionListener(e ->
            collegeIdField.requestFocusInWindow()
        );

        // College ID -> Email Address
        collegeIdField.addActionListener(e ->
            emailField.requestFocusInWindow()
        );

        // Email Address -> Role
        emailField.addActionListener(e -> {
            roleBox.requestFocusInWindow();
            roleBox.showPopup();
        });

        // Role -> Password
        roleBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    roleBox.hidePopup();
                    passwordField.requestFocusInWindow();
                    e.consume();
                }
            }
        });

        // Password -> Confirm Password
        passwordField.addActionListener(e ->
            confirmPasswordField.requestFocusInWindow()
        );

        // Confirm Password -> no automatic registration
        confirmPasswordField.addActionListener(e -> {
            // CREATE ACCOUNT button should be clicked manually.
        });

        // ===== BUTTON ACTIONS =====

        backButton.addActionListener(e -> openLogin());

        hasAcc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLogin();
            }
        });

        registerButton.addActionListener(e -> registerAccount());
    }

    // ===== REGISTER VALIDATION =====
    private void registerAccount() {

        String name = nameField.getText().trim();
        String collegeId = collegeIdField.getText().trim();
        String email = emailField.getText().trim();

        String password = new String(passwordField.getPassword());
        String confirmPassword =
            new String(confirmPasswordField.getPassword());

        String role = (String) roleBox.getSelectedItem();

        if (name.isEmpty() ||
            collegeId.isEmpty() ||
            email.isEmpty() ||
            password.isEmpty() ||
            confirmPassword.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please fill in all fields.",
                "Missing Information",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (!email.matches(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        )) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid email address.",
                "Invalid Email",
                JOptionPane.WARNING_MESSAGE
            );
            emailField.requestFocusInWindow();
            return;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(
                this,
                "Password must contain at least 6 characters.",
                "Weak Password",
                JOptionPane.WARNING_MESSAGE
            );
            passwordField.requestFocusInWindow();
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(
                this,
                "Password and Confirm Password do not match.",
                "Password Mismatch",
                JOptionPane.WARNING_MESSAGE
            );
            confirmPasswordField.setText("");
            confirmPasswordField.requestFocusInWindow();
            return;
        }

        if (!agree.isSelected()) {
            JOptionPane.showMessageDialog(
                this,
                "Please agree to Terms & Privacy Policy.",
                "Agreement Required",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
            this,
            "Account details validated successfully!\n\n" +
            "Name: " + name +
            "\nCollege ID: " + collegeId +
            "\nEmail: " + email +
            "\nRole: " + role +
            "\n\nDatabase registration is not connected yet.",
            "Registration Successful",
            JOptionPane.INFORMATION_MESSAGE
        );

        openLogin();
    }

    // ===== OPEN LOGIN FRAME =====
    private void openLogin() {
        new LoginFrame().setVisible(true);
        dispose();
    }

    // ===== BENEFIT COMPONENT =====
    private JPanel createBenefit(
        String icon, String t, String sub
    ) {
        JPanel p = new JPanel(new BorderLayout(12, 0));
        p.setBackground(new Color(239, 246, 255));
        p.setMaximumSize(new Dimension(300, 50));
        p.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel i = new JLabel(icon);
        i.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        i.setPreferredSize(new Dimension(32, 32));
        i.setHorizontalAlignment(SwingConstants.CENTER);
        i.setBackground(Color.WHITE);
        i.setOpaque(true);
        i.setBorder(new LineBorder(
            new Color(191, 219, 254), 1, true
        ));

        JPanel txt = new JPanel();
        txt.setLayout(new BoxLayout(txt, BoxLayout.Y_AXIS));
        txt.setBackground(new Color(239, 246, 255));

        JLabel tl = new JLabel(t);
        tl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        tl.setForeground(new Color(17, 24, 39));

        JLabel sl = new JLabel(sub);
        sl.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        sl.setForeground(new Color(107, 114, 128));

        txt.add(tl);
        txt.add(sl);

        p.add(i, BorderLayout.WEST);
        p.add(txt, BorderLayout.CENTER);

        return p;
    }

    // ===== TEXT FIELD COMPONENT =====
    private JPanel createField(
        String labelText, JTextField field, String placeholder
    ) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label.setForeground(new Color(55, 65, 81));

        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(new Color(209, 213, 219), 1, true),
                new EmptyBorder(9, 10, 9, 10)
            )
        );
        field.setMaximumSize(new Dimension(1000, 38));

        p.add(label);
        p.add(Box.createVerticalStrut(5));
        p.add(field);

        return p;
    }

    // ===== COMBO BOX COMPONENT =====
    private JPanel createComboField(
        String labelText, JComboBox<String> box
    ) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label.setForeground(new Color(55, 65, 81));

        box.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        box.setBackground(Color.WHITE);
        box.setBorder(new LineBorder(
            new Color(209, 213, 219), 1, true
        ));
        box.setMaximumSize(new Dimension(1000, 38));

        p.add(label);
        p.add(Box.createVerticalStrut(5));
        p.add(box);

        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new RegisterFrame().setVisible(true)
        );
    }
}