import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ReportFoundFrame extends JFrame {

    public ReportFoundFrame() {
        setTitle("Report Found Item");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        
        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(37, 99, 235); // blue
        Color TEXT_DARK = new Color(17, 24, 39);
        Color TEXT_GRAY = new Color(107, 114, 128);
        Color BORDER = new Color(229, 231, 235);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        // ===== HEADER - like website navbar =====
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setPreferredSize(new Dimension(0, 80));
        header.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
        
        JLabel headerTitle = new JLabel("Lost & Found  •  Report Found Item");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);

        // ===== CENTER CARD =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);
        wrapper.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1, true),
            new EmptyBorder(35, 40, 35, 40)
        ));
        // Fixed website width - centered, not stretched to edges
        card.setPreferredSize(new Dimension(850, 780));
        card.setMaximumSize(new Dimension(850, 780));

        // Card Title
        JLabel title = new JLabel("Report a Found Item");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(TEXT_DARK);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel subtitle = new JLabel("Please provide details so the owner can find it. Thank you for your honesty!");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(TEXT_GRAY);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitle.setBorder(new EmptyBorder(5, 0, 25, 0));

        card.add(title);
        card.add(subtitle);

        // ===== FORM =====
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        form.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,18,0);
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 1;

        form.add(createField("Item Name", "e.g. Black HP Laptop Bag", false), gbc);
        
        gbc.gridy++;
        JPanel row2 = new JPanel(new GridLayout(1, 2, 20, 0));
        row2.setBackground(Color.WHITE);
        row2.add(createField("Category", null, true));
        row2.add(createField("Date Found", "DD/MM/YYYY", false));
        form.add(row2, gbc);

        gbc.gridy++;
        form.add(createAreaField("Description", "Describe color, brand, distinguishing marks..."), gbc);

        gbc.gridy++;
        form.add(createField("Location Found", "e.g. Library, 2nd Floor, near Table 5", false), gbc);

        gbc.gridy++;
        JPanel row3 = new JPanel(new GridLayout(1, 2, 20, 0));
        row3.setBackground(Color.WHITE);
        row3.add(createField("Kept At", "e.g. Security Office, Admin Block", false));
        row3.add(createField("Your Contact (optional)", "So owner can reach you", false));
        form.add(row3, gbc);

        card.add(form);

        // ===== BUTTONS =====
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        btnPanel.setBackground(Color.WHITE);
        btnPanel.setBorder(new EmptyBorder(15, 0, 0, 0));
        btnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton submit = new JButton("Submit Found Item");
        submit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        submit.setBackground(PRIMARY);
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        submit.setBorder(new EmptyBorder(12, 28, 12, 28));
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        clear.setBackground(Color.WHITE);
        clear.setBorder(new LineBorder(BORDER, 1, true));
        clear.setFocusPainted(false);
        clear.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1), new EmptyBorder(11, 22, 11, 22)
        ));

        JButton back = new JButton("Back");
        back.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        back.setBackground(Color.WHITE);
        back.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1), new EmptyBorder(11, 22, 11, 22)
        ));
        back.setFocusPainted(false);

        btnPanel.add(submit);
        btnPanel.add(clear);
        btnPanel.add(back);
        card.add(btnPanel);

        wrapper.add(card);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createField(String label, String placeholder, boolean isCombo) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setBorder(new EmptyBorder(0,0,0,0));

        JLabel l = new JLabel(label);
        l.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l.setForeground(new Color(55, 65, 81));
        l.setAlignmentX(Component.LEFT_ALIGNMENT);

        JComponent field;
        if (isCombo) {
            JComboBox<String> cb = new JComboBox<>(new String[]{"ID Card", "Electronics", "Books", "Bag", "Wallet", "Keys", "Other"});
            cb.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            cb.setBackground(Color.WHITE);
            cb.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(209,213,219),1,true),
                new EmptyBorder(2,8,2,8)
            ));
            cb.setPreferredSize(new Dimension(0, 44));
            field = cb;
        } else {
            JTextField tf = new JTextField();
            tf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            if (placeholder != null) {
                tf.setText(placeholder);
                tf.setForeground(Color.GRAY);
                tf.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent e) {
                        if (tf.getText().equals(placeholder)) { tf.setText(""); tf.setForeground(Color.BLACK); }
                    }
                    public void focusLost(java.awt.event.FocusEvent e) {
                        if (tf.getText().isEmpty()) { tf.setText(placeholder); tf.setForeground(Color.GRAY); }
                    }
                });
            }
            tf.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(209,213,219),1,true),
                new EmptyBorder(8,12,8,12)
            ));
            tf.setPreferredSize(new Dimension(0, 44));
            field = tf;
        }
        field.setAlignmentX(Component.LEFT_ALIGNMENT);
        l.setBorder(new EmptyBorder(0,0,6,0));

        p.add(l);
        p.add(field);
        return p;
    }

    private JPanel createAreaField(String label, String placeholder) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);

        JLabel l = new JLabel(label);
        l.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l.setForeground(new Color(55, 65, 81));
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        l.setBorder(new EmptyBorder(0,0,6,0));

        JTextArea ta = new JTextArea(4, 20);
        ta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setBorder(new EmptyBorder(8,12,8,12));

        JScrollPane sp = new JScrollPane(ta);
        sp.setBorder(new LineBorder(new Color(209,213,219),1,true));
        sp.setAlignmentX(Component.LEFT_ALIGNMENT);

        p.add(l);
        p.add(sp);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReportFoundFrame().setVisible(true));
    }
}