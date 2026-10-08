import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ReportLostFrame extends JFrame {

    public ReportLostFrame() {
        setTitle("Report Lost Item");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(239, 68, 68); // RED for Lost
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

        JLabel headerTitle = new JLabel("Lost & Found  •  Report Lost Item");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JButton backTop = new JButton("← Back to Home");
        backTop.setFont(new Font("Segoe UI", Font.BOLD, 13));
        backTop.setForeground(Color.WHITE);
        backTop.setBackground(new Color(185, 28, 28));
        backTop.setBorder(new EmptyBorder(8, 18, 8, 18));
        backTop.setFocusPainted(false);
        header.add(backTop, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);
        wrapper.setBorder(new EmptyBorder(30, 0, 30, 0));

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(BORDER, 1, true));
        card.setPreferredSize(new Dimension(720, 680));

        // Card top
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);
        topBar.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0,0,1,0, BORDER),
            new EmptyBorder(22, 30, 18, 30)
        ));

        JLabel title = new JLabel("REPORT LOST ITEM");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(TEXT_DARK);

        JLabel subtitle = new JLabel("Provide details - we'll alert if someone finds it");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(TEXT_GRAY);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(4));
        titlePanel.add(subtitle);

        // Badge
        JLabel badge = new JLabel("● LOST REPORT");
        badge.setFont(new Font("Segoe UI", Font.BOLD, 11));
        badge.setForeground(PRIMARY);
        badge.setBackground(new Color(254, 226, 226));
        badge.setOpaque(true);
        badge.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(252,165,165),1,true),
            new EmptyBorder(6,12,6,12)
        ));

        topBar.add(titlePanel, BorderLayout.WEST);
        topBar.add(badge, BorderLayout.EAST);
        card.add(topBar);

        // ===== FORM =====
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        form.setBorder(new EmptyBorder(25, 30, 15, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0; gbc.weightx = 1;

        form.add(createField("Item Name:", new JTextField(), "Ex: Black Leather Wallet"), gbc);
        form.add(createComboField("Category:", new String[]{"ID Card", "Electronics", "Books", "Bag", "Wallet", "Keys", "Other"}), gbc);
        form.add(createAreaField("Description:", "Color, brand, identifiable marks..."), gbc);
        form.add(createField("Location Lost:", new JTextField(), "Ex: Library 2nd floor, Canteen"), gbc);
        form.add(createField("Date Lost:", new JTextField(), "DD/MM/YYYY"), gbc);

        card.add(form);

        // ===== BUTTONS =====
        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.setBackground(new Color(249,250,251));
        btnPanel.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(1,0,0,0, BORDER),
            new EmptyBorder(18, 30, 18, 30)
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

        JButton submitButton = new JButton("SUBMIT LOST REPORT");
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

        wrapper.add(card);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createField(String labelText, JTextField field, String placeholder) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(new EmptyBorder(0,0,5,0));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(55,65,81));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(209,213,219),1,true),
            new EmptyBorder(10,12,10,12)
        ));
        field.setMaximumSize(new Dimension(1000, 42));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        p.add(label);
        p.add(Box.createVerticalStrut(6));
        p.add(field);
        return p;
    }

    private JPanel createComboField(String labelText, String[] items) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(new EmptyBorder(0,0,5,0));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(55,65,81));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JComboBox<String> box = new JComboBox<>(items);
        box.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        box.setBackground(Color.WHITE);
        box.setBorder(new LineBorder(new Color(209,213,219),1,true));
        box.setMaximumSize(new Dimension(1000, 42));
        box.setAlignmentX(Component.LEFT_ALIGNMENT);

        p.add(label);
        p.add(Box.createVerticalStrut(6));
        p.add(box);
        return p;
    }

    private JPanel createAreaField(String labelText, String placeholder) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(new EmptyBorder(0,0,5,0));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(55,65,81));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea area = new JTextArea(3, 20);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(new LineBorder(new Color(209,213,219),1,true));
        scroll.setMaximumSize(new Dimension(1000, 85));
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);

        p.add(label);
        p.add(Box.createVerticalStrut(6));
        p.add(scroll);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReportLostFrame().setVisible(true));
    }
}